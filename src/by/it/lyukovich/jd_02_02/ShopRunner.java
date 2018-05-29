package by.it.lyukovich.jd_02_02;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopRunner {
    final static private int MAXCASHIERSCOUNT = 5;
    static AtomicInteger cashiersOnDuty = new AtomicInteger(0);
    static private LinkedList<Thread> cashiers = new LinkedList<>();

    public static void main(String[] args) {
        cashierStarter();
        Printer pr = new Printer();
        pr.start();
        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(0, 2);
            for (int i = 0; i <= count; i++) {
                if (Dispatcher.allBuyersInShop())
                    break;
                Buyer buyer = Dispatcher.addNewBuyer();
                buyer.start();
                Buyer.buyers.add(buyer);

            }
        }

        System.out.println("-------------------Торговый зал закрылся-----------------");
        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Util.sleep(100);
    }

    synchronized public static int countBuyers() throws ConcurrentModificationException{
        int count = 0;
        try {
            for (Thread buyer : Buyer.buyers) {
            if (buyer.getState() != Thread.State.TERMINATED)
                count++;
        }
        } catch (ConcurrentModificationException e) {}

        return count;
    }

    public static void cashierStarter(){
        for (int i = 0; i < MAXCASHIERSCOUNT; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier);
            cashier.start();
        }
    }

    static synchronized private void cashierOnDutyAdd(){
        cashiersOnDuty.getAndIncrement();
    }
    static synchronized public void cashierOnDutyRemove(){
        cashiersOnDuty.decrementAndGet();
    }

    synchronized public static int countBuyersInQueue() {
        int count;
        count = QueueBuyer.internalQueue.size();
        if (count>0) return count;
        else return 0;
    }

    static synchronized boolean allowWork(boolean bool){
        int onDuty = cashiersOnDuty.get();
        int inQueue = countBuyersInQueue();
        if (onDuty <= MAXCASHIERSCOUNT) {
            if (inQueue > 0) {
                if ((inQueue > onDuty * 5)) {
                    if (!bool) {
                        cashierOnDutyAdd();
                    }
                    return true;
                } else {
                    if (bool) {
                        cashierOnDutyRemove();
                    }
                    return false;
                }
            }else return false;
        } else return false;
    }
}