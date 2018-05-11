package by.it.kovko.jd02_03;

import java.util.HashMap;

public class ConcreteCustomer implements Customer, Runnable {

    private int priority=1;
    private int index;
    private String name;
    private long queueingTime=0;
    private int numOfGoods=5;

    // Timings
    private double timeFactor=1;
    private long enterTime=0;
    private long exitTime=0;
    private long choosingTime= Helper.Rnd(500,2000);
    private long takeCartTime= Helper.Rnd(100,200);
    private long putInCartTime= Helper.Rnd(100,200);
    private long gotInLine=0;



    private Shop shop;
    ConcreteCustomer(int i, Shop shop){
        index=i;
        name="Покупатель #"+index;
        this.shop=shop;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setName(String name) {
        this.name = name;
    }

//    public double getTimeFactor() {
//        return timeFactor;
//    }

    void setTimeFactor(double timeFactor) {
        this.timeFactor = timeFactor;
    }


    private HashMap<Shop.Goods, Integer> shoppingList = new HashMap<>();
    public HashMap<Shop.Goods, Integer> getShoppingList(){return shoppingList;}

    @Override
    public long getQueueingTime() {
        return queueingTime;
    }
    @Override
    public void setQueueingTime() {
        queueingTime = System.currentTimeMillis();
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public void enter() {
        shop.shopAcquire();
        Helper.action(name+" вошел в магазин",(long)(enterTime*timeFactor));
        //shop.addCustomer();
    }

    @Override
    public void exit() {
        Helper.action(name+" купил " + shoppingList,(long)(enterTime*timeFactor));
        Helper.action(name+" вышел из магазина",(long)(exitTime*timeFactor));
        shop.returnCart();
        shop.customersLatch.countDown();
        //shop.subCustomer();
    }

    @Override
    public void takeCart() {
        shop.getCart();
        Helper.action(name+" взял тележку",(long)(takeCartTime*timeFactor));
    }

    @Override
    public void choose() {
        Shop.Goods g = Shop.Goods.values()[Helper.Rnd(Shop.Goods.values().length-1)];
        shoppingList.computeIfPresent(g,(k,v) -> ++v);
        shoppingList.putIfAbsent(g,1);
        Helper.action(name+" выбрал товар "+g.name(),(long)(choosingTime*timeFactor));
    }

    @Override
    public void putIntoCart() {
        Helper.action(name+" положил товар в тележку",(long)(putInCartTime*timeFactor));

    }

    @Override
    public void standInLine() {
        shop.shopRelease();
        Helper.action(name+" встал в очередь",(long)(gotInLine*timeFactor));
        shop.q.putCustomer(this);
        synchronized (this){
            try {
                Helper.action(name+" стоит в очереди",0);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void shopping(){
        takeCart();
        int concreteNumOfGoods= Helper.Rnd(1,numOfGoods);
        for (int i = 0; i < concreteNumOfGoods; i++) {
            choose();
            putIntoCart();
        }
        standInLine();
    }
    @Override
    public void run() {
        enter();
        shopping();
        exit();
    }

    @Override
    public int compareTo(Customer o) {
        if (this.priority<o.getPriority()){
            return 1;
        } else if  (this.priority>o.getPriority()) {
            return -1;
        }
            if (this.queueingTime<o.getQueueingTime())
                return 1;
            else if (this.queueingTime>o.getQueueingTime())
                return -1;
            else
                return 0;
        }
    }


