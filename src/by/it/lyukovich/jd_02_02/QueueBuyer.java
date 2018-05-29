package by.it.lyukovich.jd_02_02;

import java.util.LinkedList;

public class QueueBuyer {
    public static LinkedList<Buyer> internalQueue = new LinkedList<>();
    static void addBuyer(Buyer buyer) {
        synchronized (internalQueue) {
            internalQueue.addLast(buyer);
        }
    }

    static Buyer extractBuyer() {
        synchronized (internalQueue) {
            return internalQueue.pollFirst();
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        synchronized (internalQueue) {
            return internalQueue.indexOf(buyer) > -1;
        }
    }

}
