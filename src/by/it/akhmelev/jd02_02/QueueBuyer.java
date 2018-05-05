package by.it.akhmelev.jd02_02;

import java.util.LinkedList;

class QueueBuyer {

    private final static LinkedList<Buyer> internalQueue = new LinkedList<>();

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }


    static void addBuyer(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            internalQueue.addLast(buyer);
            printSize();
        }
    }


    static Buyer extractBuyer() {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            Buyer buyer = internalQueue.pollFirst();
            printSize();
            return buyer;
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            return internalQueue.indexOf(buyer) > -1;
        }
    }

}
