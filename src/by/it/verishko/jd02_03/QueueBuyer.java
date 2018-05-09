package by.it.verishko.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class QueueBuyer {
    private final static BlockingQueue<Buyer> internalQueue =
            new LinkedBlockingQueue<>(30);

    static void addBuyer(Buyer buyer) {
        try {
            internalQueue.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printSize();
    }

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }

    static Buyer extractBuyer() {
        Buyer buyer = internalQueue.poll();
        printSize();
        return buyer;
    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.contains(buyer);
    }
}
