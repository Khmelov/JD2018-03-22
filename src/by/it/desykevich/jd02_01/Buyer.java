package by.it.desykevich.jd02_01;

public class Buyer  extends Thread implements IBuyer,IUseBasket {

    
    private String name;

    public Buyer(int number) {
       name = "Покупатель №"+ number;
    }



    @Override
    public String toString() {

        return name+" ";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGood();
        putGoodsToBasket();
        goOut();
    }



    @Override
    public void enterToMarket() {
        System.out.println(this+"Зашел в магазин");
    }

    @Override
    public void takeBasket() {
        Util.sleep(100, 200);
        System.out.println(this + "взял корзину.");
    }


    @Override
    public void chooseGood() {

        for (int i = 1; i <= Util.random(5); i++) {
            Util.sleep(500, 2000);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + "выбрал товар " + goodName + " цена: " + goodPrice + ".");
        }
        System.out.println(this + "завершил выбор.");


    }

    @Override
    public void putGoodsToBasket() {
        Util.sleep(100, 200);
        System.out.println(this + "положил товары в корзину.");

    }

    @Override
    public void goOut() {
        System.out.println(this+"покупатель вышел из магазина");
    }
}
