package by.it.sgolovach.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    private final static AtomicInteger numberBuyer = new AtomicInteger(0);
    final static int planCount = 100;

    private static int factCount = 0;


    synchronized static boolean planComplete() {
        return factCount >= planCount;
    }

    static Buyer addNewBuyer() {
        return new Buyer(numberBuyer.addAndGet(1));
    }


    synchronized static void finalBuyer() {
        factCount++;
    }

    synchronized static boolean allBuyersInShop() {
        return numberBuyer.get() == planCount;
    }


}
