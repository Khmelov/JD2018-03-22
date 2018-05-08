package by.it.danilevich.jd02_02;

//import java.util.Iterator;
import java.util.Map;

class Buyer extends Thread implements IBuyer {
    private String name;
    private double koefSpeed;
    public Buyer(int name, boolean pens) {
        if (!pens) {
            this.name = "Покупатель-пенсионер №" + name;
            this.koefSpeed = 1.15;
        } else {
            this.name = "Покупатель №" + name;
            this.koefSpeed = 1;
        }
     }
     String getNameBuyer(){
        return this.name;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToKass();
        goOut();
    }

    private void goToKass() {
        Dispatcher.buyersInQueuq.addbuyer(this);
        System.out.println(this.name + " встал в общую очередь");
        QueueBuyer.printQueue();
        //тут можно проверять сколько человек в очереди и закрывать или открывать кассу
        int countInQueue = Dispatcher.buyersInQueuq.getSize();
        int needKass = countInQueue/Dispatcher.getMaxByerInCashier();
        int openKass = Dispatcher.getAmountOpenKass();
        synchronized (this) {
            if (openKass < needKass) {
                //открываем дополнительные кассы
                for (Map.Entry<Cashier, String> s : Dispatcher.cashiers.entrySet()) {
                    if (s.getValue() == "close") {
                        s.getKey().notify();//возобновили поток
                        Dispatcher.openKass(s.getKey());
                        openKass++;
                        if (openKass == needKass) break;
                    }
                }
            } else if (openKass > needKass) {
                //убираем кассы которые открыты
                for (Map.Entry<Cashier, String> s : Dispatcher.cashiers.entrySet()) {
                    if (s.getValue() == "open") {
                        //установим признак, чтобы никто в эту кассу не заходил
                        Dispatcher.BlockForEnter(s.getKey());
                        //мы должны выпустить всех кто в кассе, чтобы закрыть ее

                        while (s.getKey().getAmountBuyer() != 0) {
                            try {
                                s.getKey().wait();//приостановили поток
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Dispatcher.openKass(s.getKey());
                            openKass--;
                            if (openKass == needKass) break;
                        }

                    }
                }

            }
        }



        //не выходим из магазина пока покупатель или в общей очереди или в кассе -
        while (Dispatcher.buyersInKass.contains(this)&&Dispatcher.buyersInQueuq.contains(this)){//
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterToMarket() {
     System.out.println(this.name + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this.name + " зашел в торговый зал");
        Backet backet = new Backet(this);
        Util.sleep(Util.random(100,200));
        backet.takeBacket();
        Util.sleep(Util.random(100,200));
        backet.putGoodsToBacket();
        int timeForSelect = Util.random((int) (500*this.koefSpeed),(int) (2000*this.koefSpeed));//в миллисекундах
        Util.sleep(timeForSelect);
        System.out.println(this.name + " выбрал товар за " + (double)timeForSelect/1000+" сек.");
    }


    public void goOut() {
        System.out.println(this.name + " вышел из магазина");
        Dispatcher.finallBuer();

    }
}
