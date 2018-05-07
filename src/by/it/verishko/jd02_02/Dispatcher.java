package by.it.verishko.jd02_02;

public class Dispatcher {

    private static int numberBuyer = 0;
    private final static int planCount = 100;
    private static int processCount = 0;
    private static int factCount = 0;

    synchronized static boolean planComplete() {
        return factCount >= planCount;
    }

    synchronized static Buyer addNewBuyer() {
        processCount++;
        return new Buyer(++numberBuyer);
    }

    synchronized static void finalBuyer() {
        processCount--;
        factCount++;
    }

    static synchronized boolean allBuyersInShop() {
        return numberBuyer == planCount;
    }
}
