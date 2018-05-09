package by.it.verishko.jd02_03;

public class Dispatcher {

    private static final int numberBuyer = 0;
    private static final int planCount = 5;
//    private static int processCount = 0;
    private static int factCount = 0;

    synchronized static boolean planComplete() {
        return factCount >= planCount;
    }

    synchronized static Buyer addNewBuyer() {
        return new Buyer(numberBuyer);
    }

    synchronized static void finalBuyer() {
        factCount++;
    }

    static synchronized boolean allBuyersInShop() {
        return numberBuyer == planCount;
    }
}
