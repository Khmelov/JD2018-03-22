package by.it.verishko.jd02_01;

import java.util.LinkedList;

class QueueBuyer {

    private static LinkedList<Buyer> internalQueue = new LinkedList<>();

    void addBuyer(Buyer byuer) {
        internalQueue.addLast(byuer);
    }

    static Buyer extractByuer () {
        return internalQueue.pollFirst();
    }

}
