package by.it.lyukovich.jd_02_01;

import java.util.LinkedList;

public class QueueBuyer {
    private static LinkedList<Buyer> internalQueue = new LinkedList<>();
    static void addBuyer(Buyer buyer) {
        internalQueue.addLast(buyer);
    }
    static Buyer extractBuyer() {
        return internalQueue.pollFirst();
    }
    static Buyer current(){return internalQueue.getFirst();}
}
