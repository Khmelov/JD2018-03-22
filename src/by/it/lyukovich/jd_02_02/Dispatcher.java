package by.it.lyukovich.jd_02_02;

public class Dispatcher {
    private static int numberBuyer = 0;
    private static Goods goods = new Goods();;
    private final static int planCount = 100;
    private static int processCount = 0;
    private static int factCount = 0;


    synchronized static Buyer addNewBuyer() {
        processCount++;
        return new Buyer(++numberBuyer, goods);
    }

    synchronized static void finalBuyer() {
        processCount--;
        factCount++;
    }

    static synchronized boolean allBuyersInShop() {
        return numberBuyer == planCount;
    }
    static synchronized boolean endCashiers() {
        if (allBuyersInShop() && ShopRunner.cashiersOnDuty.get()==0) return true;
        else return false;
    }
}
