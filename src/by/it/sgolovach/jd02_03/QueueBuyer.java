package by.it.sgolovach.jd02_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

class QueueBuyer {

//    private final static Integer monitor1 = 0;
    final static PriorityBlockingQueue<Buyer> internalQueue = new PriorityBlockingQueue<>(30);
//    final static LinkedList<Buyer> internalQueuePensioner = new LinkedList<>();


    static void printSize() {

            int count = internalQueue.size();
            if (count > 0) System.out.println("Длина очереди покупателей: " + count);

    }

    static void addBuyer(Buyer buyer) {

            internalQueue.put(buyer);
            printSize();

    }

//    static void addBuyerPensioner(Buyer buyer) {
//        synchronized (internalQueuePensioner) {
//            internalQueuePensioner.addLast(buyer);
//        }
//    }

    static Buyer extractBuyer() {
            Buyer buyer = internalQueue.poll();
            printSize();
            return buyer;
    }

//    static Buyer extractBuyerPensioner() {
//        synchronized (internalQueuePensioner) {
//            Buyer buyer = internalQueuePensioner.pollFirst();
//            printSize();
//            return buyer;
//        }
//    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.size()>0;
    }

//    static boolean buyerInQueuePensioner(Buyer buyer) {
//        synchronized (internalQueuePensioner) {
//            return internalQueuePensioner.indexOf(buyer) > -1;
//        }
//    }

}
