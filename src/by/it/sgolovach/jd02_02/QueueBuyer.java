package by.it.sgolovach.jd02_02;

import java.util.LinkedList;

class QueueBuyer {

    final static LinkedList<Buyer> internalQueue = new LinkedList<>();
    final static LinkedList<Buyer> internalQueuePensioner = new LinkedList<>();

    static void printSize() {
        int count = internalQueue.size() + internalQueuePensioner.size();
        if (count > 0) System.out.println("Длина очереди покупателей: " + count);
    }

    static void addBuyer(Buyer buyer) {
        synchronized (internalQueue) {
            internalQueue.addLast(buyer);
        }
    }

    static void addBuyerPensioner(Buyer buyer) {
        synchronized (internalQueuePensioner) {
            internalQueuePensioner.addLast(buyer);
        }
    }

    static Buyer extractBuyer() {
        synchronized (internalQueue) {
            Buyer buyer = internalQueue.pollFirst();
            printSize();
            return buyer;
        }
    }

    static Buyer extractBuyerPensioner() {
        synchronized (internalQueuePensioner) {
            Buyer buyer = internalQueuePensioner.pollFirst();
            printSize();
            return buyer;
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        synchronized (internalQueue) {
            return internalQueue.indexOf(buyer) > -1;
        }
    }

    static boolean buyerInQueuePensioner(Buyer buyer) {
        synchronized (internalQueuePensioner) {
            return internalQueuePensioner.indexOf(buyer) > -1;
        }
    }

}
