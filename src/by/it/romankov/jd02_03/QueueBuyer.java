package by.it.romankov.jd02_03;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

class QueueBuyer {

    private final static PriorityBlockingQueue<Buyer> internalQueue = new PriorityBlockingQueue <Buyer>(30);

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }


    static void addBuyer(Buyer buyer) {

            internalQueue.put(buyer);
            printSize();
        }



    static Buyer extractBuyer() {
            Buyer buyer= internalQueue.poll();
            printSize();
            return buyer;
        }


    static boolean buyerInQueue(Buyer buyer) {
        synchronized (internalQueue) {
            return internalQueue.size()>0;
        }
    }

}
