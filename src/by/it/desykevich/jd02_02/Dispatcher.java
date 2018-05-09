package by.it.desykevich.jd02_02;

import java.util.LinkedList;

class Dispatcher {

    private final static LinkedList<Buyer> queue = new LinkedList<>();
    static int speed = 25;
    private final static int planCount = 100;
    private static int numberBuyer = 0;
    private static int processCount = 0;
    private static int factCount = 0;
    private static int servedCustomers = 0;



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

    synchronized static boolean allBuyersInShop() {

        return numberBuyer == planCount;
    }

    synchronized public static int getQueueSize() {
        return queue.size();
    }

    public static int getServedCustomers() {
        return servedCustomers;
    }

    public static int getAllCustomers() {
        return factCount;
    }

    synchronized static void incNumOfServedCustomers() {
        ++servedCustomers;
    }

}
