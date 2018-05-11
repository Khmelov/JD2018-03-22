package by.it.kirova.jd02_03;


import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket, Comparable<Buyer> {
    private static Semaphore limitBuyersChooseGoods = new Semaphore(20);
    private static Semaphore limitTakeBacket = new Semaphore(50);

    private String name;
    private Goods goods;

    private boolean pensioner;
    private ArrayList<String> backet;


    public boolean isPensioner() {
        return pensioner;
    }

    public Integer getQueuePriority() {
        return pensioner ? 1 : 2;
    }

    @Override
    public int compareTo(Buyer o) {
        return 0;
    }


    public Buyer(int number, Goods goods) {
        name = "Покупатель №" + number;
        this.goods = goods;
        pensioner = Util.random(1, 4) == 4;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            Printer.printMessage("\t" + this + "ожидает разрешение взять корзину: " + Buyer.limitTakeBacket.availablePermits());
            limitTakeBacket.acquire();
            Printer.printMessage("\t" + this + "взял корзину: " + Buyer.limitTakeBacket.availablePermits());
            takeBacket();
            chooseGoods();
            goQueue();
            goOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            limitTakeBacket.release();
        }
    }

    @Override
    public void enterToMarket() {
        Printer.printMessage("\t" + this + "зашел в магазин");
    }

    private double getSpeed() {
        return pensioner ? Util.random(1, 3) / 2.0 : 1;
    }

    @Override
    public void chooseGoods() {
        try {
            Printer.printMessage("\t" + this + "ожидает разрешение зайти в зал: " + Buyer.limitBuyersChooseGoods.availablePermits());
            limitBuyersChooseGoods.acquire();
            Printer.printMessage("\t" + this + "зашел в торговый зал: " + Buyer.limitBuyersChooseGoods.availablePermits());
            Util.randomSleep(500, 2000, getSpeed());
            int goodsCount = Util.random(1, 4);
            for (int i = 0; i < goodsCount; i++) {
                String g = goods.getRandomGood();
                putGoodsToBacket(g);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            limitBuyersChooseGoods.release();
        }
        //QueueBuyer.addBuyer(this); теперь это происходит в goQueue()
    }

    @Override
    public void takeBacket() {
        Util.randomSleep(100, 200, getSpeed());
        backet = new ArrayList<>();
        Printer.printMessage("\t" + this + " взял корзину");
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
        Printer.printMessage(this + "вышел из магазина");
        Dispatcher.finalBuyer();
    }

}
