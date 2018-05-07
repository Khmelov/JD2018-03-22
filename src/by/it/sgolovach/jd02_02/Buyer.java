package by.it.sgolovach.jd02_02;

import java.util.ArrayList;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private String name;

    int nm = 0;

    boolean pensioneer() {
        if (nm % 4 == 0) return true;
        else return false;
    }

    public Buyer(int number) {
        nm = number;
        if (!pensioneer()) {
            name = "Покупатель № " + number;
        } else {
            name = "Покупатель № " + number + " пенсионер";
        }
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
        putGoodsToBacket();
        goQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        if (!pensioneer()) {
            Util.sleep(Util.random(500, 2000));
        } else {
            Util.sleep(Util.random(750, 3000));
        }
        int count = Util.random(1, 4);
        ArrayList<String> goods = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int countGood = Util.random(0, 9);
            goods.add(Runner.goodCatalague.get(countGood));
        }
        System.out.println(this + "выбрал товар");
        BacketBuyers.backetByuer(nm, goods);
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Dispatcher.finalBuyer();
    }

    @Override
    public void goQueue() {
        System.out.println(this + "встал в очередь");
        if (nm % 4 == 0) QueueBuyer.addBuyerPensioner(this);
        QueueBuyer.addBuyer(this);
        synchronized (this) {
            while (QueueBuyer.buyerInQueuePensioner(this) || QueueBuyer.buyerInQueue(this))
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void takeBacket() {
        if (!pensioneer()) {
            Util.sleep(Util.random(100, 200));
        } else {
            Util.sleep(Util.random(150, 300));
        }
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        int cost = 0;
        if (!pensioneer()) {
            Util.sleep(Util.random(100, 200));
        } else {
            Util.sleep(Util.random(150, 300));
        }
        String str = "";
        for (Object o : BacketBuyers.backetBuyer.get(nm)) {
            str += o + " ";
            cost += Runner.goods.get(o);
        }
        System.out.println(this + "положил " + str + "в корзину, на сумму = " + cost);

    }
}
