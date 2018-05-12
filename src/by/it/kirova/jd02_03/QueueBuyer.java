package by.it.kirova.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class QueueBuyer {

    public final static List<Cashier> cashiers = new ArrayList<>();

    private final static BlockingQueue<Buyer> internalQueue =
            new LinkedBlockingQueue<>(30);



    static void addBuyer(Buyer buyer) {

        try {
            internalQueue.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int openCashiersCount = getOpenedCashiersCount();
        int priority = buyer.getQueuePriority();
        int index = 0;
        for (Buyer b: internalQueue) {
            if(b.getQueuePriority() <= priority)
                index++;
        }
        boolean needOpen = false;
        if(openCashiersCount == 0 || Math.ceil(internalQueue.size() / 5.0) > openCashiersCount){
            needOpen = true;
        }
        if(needOpen)
            openCashier();
    }

    public static int getSize() {
        synchronized (internalQueue) {
            return internalQueue.size();
        }
    }

    public static Cashier createCashier(){
        Cashier c = new Cashier(cashiers.size());
        cashiers.add(c);
        return c;
    }

    private static void openCashier(){
        for (Cashier c: cashiers) {
            if(!c.isOpen()){
                c.openCashier();
                return;
            }
        }
    }

    private static int getOpenedCashiersCount(){
        int count = 0;
        for (Cashier c: cashiers) {
            if(c.isOpen()){
                count++;
            }
        }
        return count;
    }


    static Buyer extractBuyer() {
        Buyer buyer = internalQueue.poll();
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
