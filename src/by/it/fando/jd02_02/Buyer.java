package by.it.fando.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private String name;
    public Buyer (int number) { name = "Покупатель №" + number; }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Зашел в торговый зал");
        Util.sleep(Util.random(500,1000));
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void goQueue() {
        System.out.println(this + "встал в очередь");
        QueueBuyer.addBuyer(this);

        synchronized (this) {
            while (QueueBuyer.buyerInQueue(this)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Controller.finalBuyer();
    }

    @Override
    public void takeBasket() {
        Util.sleep(Util.random(100,200));
        System.out.println(this+"взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        int r = Util.random(1,4);
        for ( int i = 1; i <=r ; i++ ) {
            Util.sleep(Util.random(100, 200));
            int w = Util.random(0, Goods.pairs.size()-1);
            String key = Goods.pairs.get(w).getKey();
            Double value = Goods.pairs.get(w).getValue();

            System.out.println(this+"Положил товар " + key +" (" + value + ") в корзину");
        }
    }
}
