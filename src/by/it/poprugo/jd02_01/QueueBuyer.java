package by.it.poprugo.jd02_01;

import java.util.LinkedList;
import java.util.Queue;

class QueueBuyer {

    private static LinkedList<Buyer> internalQueue = new LinkedList<>();

    static void addBuyer(Buyer buyer) {
        internalQueue.addLast(buyer);
        //+++ чтобы проверить ?
        if (Math.random()>0.5)
            System.out.println("Extract" + extractBuyer());
        //+++
    }

    static Buyer extractBuyer() {
        return internalQueue.pollFirst();
    }
}
