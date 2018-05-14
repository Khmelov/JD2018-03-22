package by.it.uskoryaev.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueBuyer {
    private final static BlockingQueue<Buyer> internalQueue = new LinkedBlockingQueue<>(30);

    private static void printSize() {
        if (internalQueue.size() > 0) {
            System.out.println("Длинна очереди покупателей: " + internalQueue.size());
        }
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
        Buyer buyer = internalQueue.poll();
        printSize();
        return buyer;

    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.contains(buyer);
    }
}
