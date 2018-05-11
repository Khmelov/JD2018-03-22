package by.it.sgolovach.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class DispatcherCashier extends Thread {


    static int countCashier = 5;

    static List<Thread> cashiers = new ArrayList<>();


    @Override
    public void run() {
        for (int i = 1; i <= countCashier; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            cashier.start();
        }

        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread.yield();

        System.out.println("Обслужено клиентов:" + QueueBuyer.sizeQueueRemove);
        System.out.println("Длина очереди:"+QueueBuyer.sizeQueueInAdd);
        System.out.println("Выручка магазина:"+Cashier.countShop);
        System.out.println("Магазин закрылся!!!");

    }


}
