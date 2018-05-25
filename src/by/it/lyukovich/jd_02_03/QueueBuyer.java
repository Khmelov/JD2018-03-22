package by.it.lyukovich.jd_02_03;

import java.util.concurrent.*;

public class QueueBuyer {

    public final static BlockingQueue<Buyer> internalQueue =
            new LinkedBlockingQueue<>(30);


    static void addBuyer(Buyer buyer) {
        try {
            internalQueue.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extractBuyer() {
            Buyer buyer = internalQueue.poll();
        return buyer;
    }

    static boolean buyerInQueue(Buyer buyer) {
        synchronized (internalQueue) {
            return internalQueue.contains(buyer);
        }
    }



}
