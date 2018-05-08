package by.it.verishko.jd02_02;

import java.util.LinkedList;

class QueueBuyer {

    private final static LinkedList<Buyer> internalQueue = new LinkedList<>();

    static void addBuyer(Buyer buyer) {
        synchronized (internalQueue) {
            internalQueue.addLast(buyer);
        }
    }

    static Buyer extractBuyer() {
        synchronized (internalQueue) {
            return internalQueue.pollFirst();
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        synchronized (internalQueue) {
            return internalQueue.indexOf(buyer) > -1;
        }
    }
}
