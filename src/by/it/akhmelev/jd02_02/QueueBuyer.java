package by.it.akhmelev.jd02_02;

import java.util.LinkedList;

class QueueBuyer {

    private final static LinkedList<Buyer> internalQueue = new LinkedList<>();

    static void addBuyer(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            internalQueue.addLast(buyer);
        }
    }

    static Buyer extractBuyer() {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            return internalQueue.pollFirst();
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            return internalQueue.indexOf(buyer) > -1;
        }
    }

}
