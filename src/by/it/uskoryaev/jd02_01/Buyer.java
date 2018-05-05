package by.it.uskoryaev.jd02_01;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer,IUseBacket {
    private static HashMap<Integer, String> goods = new HashMap();

    private String name;

    Buyer(int number) {
        name = "Покупатель № " + number;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void run() {
        super.run();
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Покупатель зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Зашел на ТЗ");
        Util.sleep(Util.random(500, 2000));
        System.out.println(this + "выбрал товар");
        QueueBuyer.addBuyer(this);

    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из ТЗ");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "взял корзинку");
    }

    @Override
    public void putGoodsToBacket() {

    }
}

//    @Override
//    public void putGoodsToBacket() {
//        for (int i = 0; i <4 ; i++) {
//            int tovar = (int)(Math.random()*7);
//            System.out.println();
//        }
//        System.out.println(this + "положил выбранный товар в корзину");
//
//    }
//    void addGoods(){
//        goods.put(1,"Хлеб");
//        goods.put(2,"Батон");
//        goods.put(3,"Молоко");
//        goods.put(4,"Мясо");
//        goods.put(5,"Спички");
//        goods.put(6,"Фрукты");
//        goods.put(7,"Овощи");
//    }
//}
