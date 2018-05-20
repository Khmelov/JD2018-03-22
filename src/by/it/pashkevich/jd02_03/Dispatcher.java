package by.it.pashkevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static int speed = 25;
    private final static int planCount = 100;

    private static final AtomicInteger numberBuyer = new AtomicInteger(0);

    private static final AtomicInteger factCount =new AtomicInteger(0);



    synchronized static boolean planComplete() {
        return factCount.get() >= planCount;
    }


    synchronized static Buyer addNewBuyer() {

        return new Buyer(numberBuyer.addAndGet(1));
    }


    synchronized static void finalBuyer() {
       factCount.addAndGet(1);
    }

    synchronized static boolean allBuyersInShop() {
        return numberBuyer.get()>= planCount;
    }


}
