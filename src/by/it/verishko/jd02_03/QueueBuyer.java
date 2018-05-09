package by.it.verishko.jd02_03;

import java.util.concurrent.PriorityBlockingQueue;

class QueueBuyer {

    private final static PriorityBlockingQueue<Buyer> internalQueue =
            new PriorityBlockingQueue<Buyer>(30);

    static void addBuyer(Buyer buyer) {
        internalQueue.put(buyer);
        printSize();
    }

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди " + internalQueue);
    }

    static Buyer extractBuyer() {
        Buyer buyer = internalQueue.poll();
        printSize();
        return buyer;
    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.size() > 0;
    }
}
