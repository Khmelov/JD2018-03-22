package by.it.uskoryaev.jd02_02;

import java.util.LinkedList;

public class QueueBuyer {
    private final static LinkedList<Buyer> internalQueue = new LinkedList<>();

    private static void printSize() {
        if (internalQueue.size() > 0) {
            System.out.println("Длинна очереди покупателей: " + internalQueue.size());
        }
    }

    static void addBuyer(Buyer buyer) {
        synchronized (internalQueue) {
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
