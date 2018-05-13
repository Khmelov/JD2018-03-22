package by.it.danilevich.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class QueueBuyer {


    private final static BlockingQueue<Buyer> internalQueue =
            new LinkedBlockingQueue<>(30);

    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Длина очереди покупателей: " + internalQueue.size());
    }

    public static int getSizeQueue() {
        return internalQueue.size();
    }

    static void addBuyer(Buyer buyer) {
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
        return buyer;
    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.contains(buyer);

        //ошибка из-за которой не работала наша работа в классе
        //этот метод вызывается в goQueue() класса Buyer
        //и его смысл найти конкретного покупателя в очереди
        //а не просто проверить есть ли какой-то покупатель в очереди
        //поэтому такой способ приводит к ошибке

        //return internalQueue.size() > 0;

        //p.s. это ошибка не многопоточки, а логики.
        //Sorry (

    }

}
