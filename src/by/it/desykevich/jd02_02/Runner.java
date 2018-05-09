package by.it.desykevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    static List<Thread> cashiers = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier);
            cashier.start();
        }


        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(2);
            for (int j = 1; j <= count; j++) {
                if (Dispatcher.allBuyersInShop())
                    break;
                Buyer buyer = Dispatcher.addNewBuyer();
                buyer.start();
            }
        }


        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread.yield();

        Util.sleep(100, 200);
        System.out.println("Количество покупателей в очереди: " +
                Dispatcher.getQueueSize() + ".");
        if (Dispatcher.getServedCustomers() == Dispatcher.getAllCustomers())
            System.out.println("Магазин закрыт.\n");
        System.out.println("Количество обслуженных покупателей: " +
                Dispatcher.getServedCustomers() + ".");
        System.out.println("Количество покупателей всего: " +
                Dispatcher.getAllCustomers() + ".");
//        System.out.println("Выручка магазина составила " +
//                Cashier.totalSum + " рублей.");
    }
}
