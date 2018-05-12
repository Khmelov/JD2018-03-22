package by.it.danilevich.jd02_02;

//import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;

class Buyer extends Thread implements IBuyer {
    private String name;
    private double koefSpeed;
    private double totalMoney;

    private ArrayList<ArrayList<String>> selectProduct;
    public Buyer(int name, boolean pens) {
        if (!pens) {
            this.name = "Покупатель №" + name;
            this.koefSpeed = 1.15;
        } else {
            this.name = "Покупатель-пенсионер №" + name;
            this.koefSpeed = 1;
        }
     }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    String getNameBuyer(){
        return this.name;
    }

    public ArrayList<ArrayList<String>> getSelectProduct() {
        return selectProduct;
    }

    @Override
    public String toString() {
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
        //не выходим из магазина пока покупатель или в общей очереди или в кассе -
        synchronized (this){
        while (Dispatcher.buyersInKass.contains(this)&&Dispatcher.buyersInQueuq.contains(this)){//
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
        //тут можно проверять сколько человек в очереди и закрывать или открывать кассу
        /*int countInQueue = Dispatcher.buyersInQueuq.getSize();
        int needKass = Math.max(1,countInQueue/Dispatcher.getMaxByerInCashier());
        int openKass = Dispatcher.getAmountOpenKass();
             if (openKass < needKass) {
                //открываем дополнительные кассы
                for (Map.Entry<Cashier, String> s : Dispatcher.cashiers.entrySet()) {
                    synchronized (Dispatcher.cashiersThread.get(s.getKey())){
                        if (s.getValue() == "close") {
                            System.out.println("Открываем кассу");
                            //synchronized (Dispatcher.cashiersThread.get(s.getKey())) {
                            //Dispatcher.cashiersThread.get(s.getKey()).notify();//возобновили поток
                            Dispatcher.cashiersThread.get(s.getKey()).notify();
                            Dispatcher.openKass(s.getKey());
                            openKass++;
                            if (openKass == needKass) break;
                        //}
                        }
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
                            synchronized (Dispatcher.cashiersThread.get(s.getKey())) {
                            try {
                                 Dispatcher.cashiersThread.get(s.getKey()).wait();//приостановили поток
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            Dispatcher.closeKass(s.getKey());
                            openKass--;
                             if (openKass == needKass) break;
                             }
                            }
                    }
            }*/



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
        selectProduct = backet.putGoodsToBacket();
        setTotalMoney(countMoney());
        int timeForSelect = Util.random((int) (500*this.koefSpeed),(int) (2000*this.koefSpeed));//в миллисекундах
        Util.sleep(timeForSelect);
        System.out.println(this.name + " выбрал товар за " + (double)timeForSelect/1000+" сек.");
    }


    public void goOut() {
        System.out.println(this.name + " вышел из магазина");
        Dispatcher.finallBuer();

    }

    private double countMoney(){
        double sum =0;
            for (ArrayList<String> tov: selectProduct ) {
                sum = sum+ Double.valueOf(tov.get(1));
            }
            return sum;
     }
}
