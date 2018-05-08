package by.it.sgolovach.jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class QueueBuyer {

    private final static Integer monitor1 = 0;
    final static LinkedList<Buyer> internalQueue = new LinkedList<>();
    final static LinkedList<Buyer> internalQueuePensioner = new LinkedList<>();

    static List<Integer> cashiers = new ArrayList<>();

    static void openCashier() {
        int count = 0;
        synchronized (monitor1) {
            count = internalQueuePensioner.size() + internalQueue.size();
            if (cashiers.isEmpty()) {
                Thread cashier = new Thread(new Cashier(1));
                cashiers.add(1);
                cashier.start();
            } else {
               if (count > 5 && count <= 10) {
                    Thread cashier = new Thread(new Cashier(2));
                    cashiers.add(2);
                    cashier.start();
                } else if (count > 10 && count <= 15) {
                    Thread cashier = new Thread(new Cashier(3));
                    cashiers.add(3);
                    cashier.start();
                } else if (count > 15 && count <= 20) {
                    Thread cashier = new Thread(new Cashier(4));
                    cashiers.add(4);
                    cashier.start();
                } else if (count > 20) {
                    Thread cashier = new Thread(new Cashier(5));
                    cashiers.add(5);
                    cashier.start();
                }
            }


        }


    }

    static void printSize() {
        synchronized (monitor1) {
            int count = internalQueue.size() + internalQueuePensioner.size();
            if (count > 0) System.out.println("Длина очереди покупателей: " + count);
        }
    }

    static void addBuyer(Buyer buyer) {
        synchronized (internalQueue) {
            internalQueue.addLast(buyer);
        }
    }

    static void addBuyerPensioner(Buyer buyer) {
        synchronized (internalQueuePensioner) {
            internalQueuePensioner.addLast(buyer);
        }
    }

    static Buyer extractBuyer() {
        synchronized (internalQueue) {
            Buyer buyer = internalQueue.pollFirst();
            printSize();
            return buyer;
        }
    }

    static Buyer extractBuyerPensioner() {
        synchronized (internalQueuePensioner) {
            Buyer buyer = internalQueuePensioner.pollFirst();
            printSize();
            return buyer;
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        synchronized (internalQueue) {
            return internalQueue.indexOf(buyer) > -1;
        }
    }

    static boolean buyerInQueuePensioner(Buyer buyer) {
        synchronized (internalQueuePensioner) {
            return internalQueuePensioner.indexOf(buyer) > -1;
        }
    }

}
