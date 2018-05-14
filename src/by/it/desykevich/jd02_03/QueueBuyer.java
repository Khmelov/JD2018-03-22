package by.it.desykevich.jd02_03;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class QueueBuyer {

    private final static BlockingQueue<Buyer> internalQueue =
            new LinkedBlockingQueue<>(30);

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }


    static void addBuyer(Buyer buyer) {
        try {
            internalQueue.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printSize();
    }


    static Buyer extractBuyer() {
        synchronized (internalQueue) {
            Buyer buyer=internalQueue.poll();
            printSize();
            return buyer;
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            return internalQueue.size() > 0;
        }
    }

}
