package by.it.verishko.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private String name;

    public Buyer(int number) {
        name = "Покупатель № " + number;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void takeBacket() {
        Util.sleep(100, 200);
        System.out.println(this + "взял корзину.");
    }

    @Override
    public void chooseGoods() {

        for (int i = 1; i <= Util.random(5); i++) {
            Util.sleep(500, 2000);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + "выбрал товар " + goodName + " цена: " + goodPrice + ".");
        }
        System.out.println(this + "завершил выбор.");


    }

    @Override
    public void putGoodsToBacket() {
        Util.sleep(100, 200);
        System.out.println(this + "положил товары в корзину.");

    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
    }
}
