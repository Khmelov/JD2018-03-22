package by.it.uskoryaev.jd02_03;

import java.util.concurrent.PriorityBlockingQueue;

public class QueueBuyer {
    private final static PriorityBlockingQueue<Buyer> internalQueue = new PriorityBlockingQueue<>(30);

    private static void printSize() {
        if (internalQueue.size() > 0) {
            System.out.println("Длинна очереди покупателей: " + internalQueue.size());
        }
    }

    static void addBuyer(Buyer buyer) {
        synchronized (internalQueue) {
            internalQueue.put(buyer);
            printSize();
        }
    }

    static Buyer extractBuyer() {
            Buyer buyer = internalQueue.poll();
            printSize();
            return buyer;

    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.peek() != null;
    }
}
