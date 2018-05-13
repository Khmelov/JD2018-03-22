package by.it.sgolovach.jd02_02;

import java.util.LinkedList;

public class QueueBuyer extends Thread {

    static int countBuyerInQueue = 0;

    private final static Integer monitor2 = 0;

    static int sizeQueueInAdd = 0;

    static int sizeQueueRemove = 0;


    static LinkedList<Buyer> buyersInQueue = new LinkedList<>();

    static LinkedList<Buyer> pensionerinQueue = new LinkedList<>();


    static void addInQueue(Buyer buyer) {
        synchronized (monitor2) {
            if (buyer.numberBuyer % 4 == 0) {
                pensionerinQueue.addLast(buyer);
                ++sizeQueueInAdd;
            } else {
                buyersInQueue.addLast(buyer);
                ++sizeQueueInAdd;
            }
            if (countBuyerInQueue == 0) {
                DispatcherCashier dispatcherCashier = new DispatcherCashier();
                dispatcherCashier.start();
                countBuyerInQueue++;
            }
        }
    }

    static Buyer removeOfQueue() {
        synchronized (monitor2) {
            Buyer buyer;
            if (!(pensionerinQueue.isEmpty())) {
                ++sizeQueueRemove;
                --sizeQueueInAdd;
                buyer = pensionerinQueue.pollFirst();
            } else {
                ++sizeQueueRemove;
                --sizeQueueInAdd;
                buyer = buyersInQueue.pollFirst();
            }
            return buyer;
        }

    }

    static int sizeQueue() {
        synchronized (monitor2) {
            return sizeQueueInAdd;
        }

    }
}
