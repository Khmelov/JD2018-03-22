package by.it.fando.jd02_01;

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
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Зашел в торговый зал");
        Util.sleep(Util.random(500,2000));
        System.out.println(this + "выбрал товар");
        QueueBuyer.addBuyer(this);
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
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
