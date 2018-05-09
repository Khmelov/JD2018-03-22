package by.it.verishko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static int speed = 25; //во сколько раз ускорить приложение
//    private static final int numberBuyer = 0;
    private static final int planCount = 10;

    private static final AtomicInteger numberBuyer =
            new AtomicInteger(0);

    private static final AtomicInteger factCount =
            new AtomicInteger(0);

    static boolean planComplete() {
        return factCount.get() >= planCount;
    }

    static Buyer addNewBuyer() {
        return new Buyer(numberBuyer.addAndGet(1));
    }

    static void finalBuyer() {
        factCount.addAndGet(1);
    }

    static boolean allBuyersInShop() {
        return numberBuyer.get() >= planCount;
    }
}
