package by.it.danilevich.jd02_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static int speed = 25; //во сколько раз ускорить приложение
    private final static int planCount = 100; //сколько покупателей нужно всего
    private static int MaxProductInBacket = 4;
    private static int countKass =2;
    private static final AtomicInteger numberBuyer =
            new AtomicInteger(0); //счетчик покупателей

    //private static int processCount = 0; //сколько их в магазине
    private static ArrayList<Cashier> cashierArrays = new ArrayList<>();
    private static final AtomicInteger factCount =
            new AtomicInteger(0);  //сколько вышло из магазина

    public static Semaphore canChooseGoods = new Semaphore(20);
    public static volatile int countChooseGoods =0;

    public static int getCountKass() {
        return countKass;
    }

    public static void addCashierToArray(Cashier cashier) {
        Dispatcher.cashierArrays.add( cashier);
    }

    public static ArrayList<Cashier> getCashierArrays() {
        return cashierArrays;
    }

    //синхронизация происходит по объекту Dispatcher.class
    static boolean planComplete() {
        return factCount.get() >= planCount;
    }

    //синхронизация происходит по объекту Dispatcher.class
    static Buyer addNewBuyer() {
        int n = numberBuyer.addAndGet(1);
        Boolean pens =false;
        double k = ((double)(n+1))%4;
        if (k==0.0){
            pens = true;
        }
        return new Buyer(n,pens);
    }

    //синхронизация происходит по объекту Dispatcher.class
    static void finalBuyer() {
        factCount.addAndGet(1);
    }

    //синхронизация происходит по объекту Dispatcher.class
    static boolean allBuyersInShop() {
        return numberBuyer.get() >= planCount;
    }


    static int getMaxProductInBacket() {
        return MaxProductInBacket;
    }
}
