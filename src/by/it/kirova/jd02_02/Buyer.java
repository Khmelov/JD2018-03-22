package by.it.kirova.jd02_02;


import java.util.ArrayList;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private String name;
    Goods goods;

    public boolean isPensioner() {
        return pensioner;
    }

    boolean pensioner;
    ArrayList<String> backet;

    public Integer getQueuePriority(){
        return pensioner ? 1 : 2;
    }


    public Buyer(int number, Goods goods){
        name = "Покупатель №" + number;
        this.goods = goods;
        pensioner = Util.random(1,4) == 4;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        Printer.printMessage("\t" + this + "зашел в магазин");
    }

    private double getSpeed() {
        return pensioner ? Util.random(1,3)/2.0 : 1;
    }

    @Override
    public void takeBacket() {
        Util.randomSleep(100, 200, getSpeed());
        backet = new ArrayList<>();
        Printer.printMessage("\t" + this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        Printer.printMessage("\t" + this + "зашел в торговый зал");
        Util.randomSleep(500, 2000, getSpeed());
        int goodsCount = Util.random(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            String g = goods.getRandomGood();
            putGoodsToBacket(g);
        }
        //QueueBuyer.addBuyer(this); теперь это происходит в goQueue()
    }

    @Override
    public void putGoodsToBacket(String good) {
        Util.randomSleep(100, 200, getSpeed());
        backet.add(good);
        Printer.printMessage("\t" + this + " положил товар " + good + " в корзину");
    }

    public ArrayList<String> getBacket() {
        return backet;
    }

    @Override
    public void goQueue() {
        Printer.printMessage("\t" + this + "встал в очередь");
        QueueBuyer.addBuyer(this);
        //синхронизация происходит по this (текущий покупатель)
        synchronized (this) {
            while (QueueBuyer.buyerInQueue(this))
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void goOut() {
        Printer.printMessage("\t" + this + "вышел из магазина");
        Dispatcher.finalBuyer();
    }

}
