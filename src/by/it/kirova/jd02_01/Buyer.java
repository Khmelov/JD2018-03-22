package by.it.kirova.jd02_01;


import java.util.ArrayList;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private String name;
    Goods goods;
    boolean pensioner;
    ArrayList<String> backet;

    public Buyer(int number, Goods goods) {
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
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(name + " зашел в магазин");

    }

    private double getSpeed() {
        return pensioner ? Util.random(1,3)/2.0 : 1;
    }

    @Override
    public void takeBacket() {
        Util.randomSleep(100, 200, getSpeed());
        backet = new ArrayList<>();
        System.out.println(name + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        System.out.println(name + " зашел на торговый зал");
        Util.randomSleep(500, 2000, getSpeed());
        int goodsCount = Util.random(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            String g = goods.getRandomGood();
            putGoodsToBacket(g);
        }
        QueueBuyer.addBuyer(this);
    }

    @Override
    public void putGoodsToBacket(String good) {
        Util.randomSleep(100, 200, getSpeed());
        backet.add(good);
        System.out.println(name + " положил товар " + good + " в корзину");
    }

    @Override
    public void goOut() {
        System.out.println(name + " вышел");
    }


}