package by.it.kovko.jd02_01;
import java.util.HashMap;

import static by.it.kovko.jd02_01.Util.*;


public class Customer implements Runnable{
    private static volatile int count;
    private String name;
    // Timings
    private double timeFactor=1;
    private long enterTime=0;
    private long exitTime=0;
    private long choosingTime=Rnd(500,2000);
    private long takeCartTime=Rnd(100,200);
    private long putInCartTime=Rnd(100,200);
    private long gotInLine=0;
    private Shop shop;

    private int numOfGoods=Rnd(1,4);
    private HashMap<Shop.Goods, Integer> shoppingList = new HashMap<>();

    Customer(int n, Shop shop){name="Покупатель №"+n;this.shop=shop;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public double getTimeFactor(){return timeFactor;}
    void setTimeFactor(double f){this.timeFactor=f;}
    private void enter(){
        numberOfCustomers(1);
        action(name+": Вошел в магазин",(long)(enterTime*timeFactor));
    }
    public void exit(){
        numberOfCustomers(-1);
        action("Купил: "+shoppingList,0);
        action(name+": Вышел из магазина",(long)(exitTime*timeFactor));
    }
    private void choosing(){
        Shop.Goods g = Shop.Goods.values()[Rnd(Shop.Goods.values().length-1)];
        shoppingList.computeIfPresent(g,(k,v) -> ++v);
        shoppingList.putIfAbsent(g,1);
        action(name+": Выбрал товар "+g.name(),(long)(choosingTime*timeFactor));
    }
    private void takeCart(){
        action(name+": Взял тележку",(long)(takeCartTime*timeFactor));
    }
    private void putInCart(){
        action(name+": Положил товар в тележку",(long)(putInCartTime*timeFactor));
    }
    private void gotInLine(){
        action(name+": Встал в очередь",(long)(gotInLine*timeFactor));
    }
    private void shopping(int numOfGoods){
        takeCart();
        for (int i=0;i<numOfGoods;++i) {
            choosing();
            putInCart();
        }
        gotInLine();
//        synchronized (this){
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private synchronized int numberOfCustomers(int d){return count=count+d;}
    static int numberOfCustomers(){return count;}

    @Override
    public void run() {
        enter();
        shopping(numOfGoods);
        exit();
    }
}
