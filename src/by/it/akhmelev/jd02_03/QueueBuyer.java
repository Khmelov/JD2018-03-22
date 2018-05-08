package by.it.akhmelev.jd02_03;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

class QueueBuyer {


    private final static PriorityBlockingQueue<Buyer> internalQueue =
            new PriorityBlockingQueue<>(30);

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }


    static void addBuyer(Buyer buyer) {
        internalQueue.put(buyer);
        printSize();
    }


    static Buyer extractBuyer() {
        Buyer buyer = null;
        try {
            buyer = internalQueue.poll(100, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printSize();
        return buyer;
    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.size() > 0;
    }

}
