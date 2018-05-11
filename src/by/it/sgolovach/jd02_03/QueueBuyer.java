package by.it.sgolovach.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueBuyer extends Thread {

    static final AtomicInteger countBuyerInQueue = new AtomicInteger(0);

    static final AtomicInteger sizeQueueInAdd = new AtomicInteger(0);

    static final AtomicInteger sizeQueueRemove = new AtomicInteger(0);

    static final ConcurrentLinkedQueue<Buyer> buyersInQueue = new ConcurrentLinkedQueue<>();

    static final ConcurrentLinkedQueue<Buyer> pensionerinQueue = new ConcurrentLinkedQueue<>();


    static void addInQueue(Buyer buyer) {
        if (sizeQueue() <= 30) {
            if (buyer.numberBuyer % 4 == 0) {
                pensionerinQueue.add(buyer);
                sizeQueueInAdd.getAndIncrement();
            } else {
                buyersInQueue.add(buyer);
                sizeQueueInAdd.getAndIncrement();
            }
        }
        if (countBuyerInQueue.get() == 0) {
            DispatcherCashier dispatcherCashier = new DispatcherCashier();
            dispatcherCashier.start();
            countBuyerInQueue.getAndIncrement();
        }
    }

    static Buyer removeOfQueue() {
        Buyer buyer;
        if (!(pensionerinQueue.isEmpty())) {
            sizeQueueRemove.incrementAndGet();
            sizeQueueInAdd.getAndDecrement();
                buyer = pensionerinQueue.poll();
        } else {
            sizeQueueRemove.incrementAndGet();
            sizeQueueInAdd.getAndDecrement();
                buyer = buyersInQueue.poll();
        }
        return buyer;

    }

    static int sizeQueue() {
        return sizeQueueInAdd.get();
    }


}
