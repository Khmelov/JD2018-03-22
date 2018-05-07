package by.it.verishko.jd02_01;

import java.util.LinkedList;

class QueueBuyer {

    private static LinkedList<Buyer> internalQueue = new LinkedList<>();

    static void addBuyer(Buyer buyer) {
        internalQueue.addLast(buyer);
    }

    static Buyer extractBuyer() {
        return internalQueue.pollFirst();
    }
}
