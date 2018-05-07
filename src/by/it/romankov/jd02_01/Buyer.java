package by.it.romankov.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer,IUseBasket{
private String name;

    HashMap<String, Integer> goods = new HashMap <>();{
        goods.put("хлеб", 10);
        goods.put("батон", 24);
        goods.put("молоко", 37);
        goods.put("сосиски", 44);
        goods.put("вода", 5);
        goods.put("соль", 6);
        goods.put("чипсы", 77);
        goods.put("мука", 88);
        goods.put("макароны", 90);
        goods.put("картошка", 10);

    }

    Map.Entry[] arr = goods.entrySet().toArray(new Map.Entry[0]);




    public Buyer(int number) {
        name ="Покупатель №" + number;
    }

    @Override
    public String toString() {
        return name+" ";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+ "Зашел в торговый зал");
        Util.sleep(Util.random(500, 2000));
        System.out.println(this + "выбрал товар");
       QueueBayer.addBayer(this);
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");

    }

    @Override
    public void takeBacket() {
        Util.sleep(Util.random(100, 200));
        System.out.println(this+ "Взял корзинку");

    }

    @Override
    public void putGoodsToBacket() {
        int rand= Util.random(1,4);
        for ( int i = 1; i <=rand ; i++ ) {
            Util.sleep(Util.random(100, 200));
            int k = Util.random(0, arr.length-1);
            Object value = arr[k].getValue();
            Object key = arr[k].getKey();
            System.out.println(this+"Положил товар " + key + " стоимостью " +value+" рублей в корзину.");
        }
    }
}
