package by.it.danilevich.jd02_01;

class Buyer extends Thread implements IBuyer{
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
        goOut();
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
        System.out.println(this.name + " встал в очередь в кассу");
        QueueBuyer.addbuyer(this);
        QueueBuyer.printQueue();
    }


    public void goOut() {
        Util.sleep(500);//очередь плохо формируется без задержки, валятся ошибки
        if (QueueBuyer.queue.getFirst() == this){
            System.out.println(this.name + " рассчитался за товар");
            QueueBuyer.extractByuer(this);
            System.out.println(this.name + " вышел из магазина");
            QueueBuyer.printQueue();
            Runner.countByerShop = Runner.countByerShop-1;
            System.out.println("Всего покупателей в магазине " +Runner.countByerShop);
          }
        else goOut();
    }
}
