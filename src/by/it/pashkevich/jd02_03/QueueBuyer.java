package by.it.pashkevich.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class QueueBuyer {

    private final static BlockingQueue<Buyer> internalQueue = new LinkedBlockingQueue<>(30);

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }


    static void addBuyer(Buyer buyer) throws InterruptedException {

            internalQueue.put(buyer);
            printSize();
        }



    static Buyer extractBuyer() {
            Buyer buyer= internalQueue.poll();
            printSize();
            return buyer;
        }


    static boolean buyerInQueue(Buyer buyer) {
          return internalQueue.contains(buyer);
        }
    }


