package by.it.poprugo.jd02_03;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class QueueBuyer {
    //ConcurrentLinkedDeque<Buyer> - не подошёл
    //PriorityBlockingQueue - не подошёл
    private final static BlockingQueue<Buyer> internalQueue =
            new LinkedBlockingQueue<>(30);

    //private static LinkedList<Buyer> internalQueue = new LinkedList<>(); - было до 8 мая

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей:" + internalQueue.size());
    }

    static void addBuyer(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        try {
            internalQueue.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printSize();
    }

    static Buyer extractBuyer() {
        Buyer buyer = internalQueue.poll();
        printSize();
        //синхронизация происходит по объекту internalQueue
        return buyer;
    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.contains(buyer);
        //return internalQueue.size() > 0;
        //стараются size не использовать, т.к. данная информация ненадёжная из-за самих принципов многопоточности
    }

}
