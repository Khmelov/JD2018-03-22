package by.it.kirova.jd02_02;

import java.util.*;

class QueueBuyer {

    public final static List<Cashier> cashiers = new ArrayList<>();
    private final static LinkedList<Buyer> internalQueue = new LinkedList<>();

    private static void printSize(String action, int openedCashiers, String extra) {
        StringBuilder sb = new StringBuilder();
        sb.append(action +
                " Длина очереди покупателей: " + internalQueue.size() +
                ". Работающих касс: " + openedCashiers +
                ". " + extra);
        sb.append("\n");

        int index = 0;
        for (Buyer b: internalQueue) {
            sb.append("\t" + (++index) + "\t" + b.toString() + "\t" +
                    (b.isPensioner() ? "<Пенсионер>\n" : "\n"));
        }
        Printer.printMessage(sb.toString());
    }

    public static Cashier createCashier(){
        Cashier c = new Cashier(cashiers.size());
        cashiers.add(c);
        return c;
    }


    static void addBuyer(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            int openCashiersCount = getOpenedCashiersCount();

            int priority = buyer.getQueuePriority();
            int index = 0;
            for (Buyer b: internalQueue) {
                if(b.getQueuePriority() <= priority)
                    index++;
            }
            internalQueue.add(index, buyer);

            boolean needOpen = false;
            if(openCashiersCount == 0 || Math.ceil(internalQueue.size() / 5.0) > openCashiersCount){
                needOpen = true;
            }
            printSize("[+]", openCashiersCount, needOpen ? "Откроем еще одну кассу" : "");
            if(needOpen)
                openCashier();
        }
    }

    static void openCashier(){
        for (Cashier c: cashiers) {
            if(!c.isOpen()){
                c.openCashier();
                return;
            }
        }
    }

    static int getOpenedCashiersCount(){
        int count = 0;
        for (Cashier c: cashiers) {
            if(c.isOpen()){
                count++;
            }
        }
        return count;
    }

    static Buyer extractBuyer() {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            int openCashiersCount = getOpenedCashiersCount();

            if(openCashiersCount > 0 && Math.ceil(internalQueue.size() / 5.0) < openCashiersCount){
                printSize("[=]", openCashiersCount, "Закроем кассу");
                return null;//закроем кассу
            }

            Buyer buyer = internalQueue.poll();
            printSize("[-]", openCashiersCount, "");
            return buyer;
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        //синхронизация происходит по объекту internalQueue
        synchronized (internalQueue) {
            return internalQueue.contains(buyer);
        }
    }

}
