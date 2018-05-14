package by.it.romankov.jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class QueueBuyer {

    private final static LinkedList<Buyer> internalQueue = new LinkedList<>();
    private static List<Thread> cashiers = new ArrayList<>();

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }


    static void addBuyer(Buyer buyer) {
        synchronized (internalQueue) {
            int required = internalQueue.size() / 5  + (internalQueue.size() % 5) > 0 ? 1 : 0;
            if (required > cashiers.size()){
                Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
                cashier.start();
            }
            internalQueue.addLast(buyer);
            printSize();
        }
    }


    static Buyer extractBuyer() {
        synchronized (internalQueue) {
            Buyer buyer = internalQueue.pollFirst();
            printSize();
            return buyer;
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        synchronized (internalQueue) {
            return internalQueue.indexOf(buyer) > -1;
        }
    }

}
