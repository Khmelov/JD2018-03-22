package by.it.desykevich.jd02_02;

import by.it.desykevich.jd01_03.InOut;

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
        goQueue();
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

//@Override
//public void goQueue(){
//    System.out.println(this+"встал в очередь");
//    QueueBuyer.addBuyer(this);
//    synchronized (this){
//        try{
//            wait();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//}

    @Override
    public void goQueue() {

    }

    @Override
    public void goOut() {
        System.out.println(this+"покупатель вышел из магазина");
    }
}
