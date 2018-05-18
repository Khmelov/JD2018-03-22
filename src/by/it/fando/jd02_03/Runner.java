package by.it.fando.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static List<Thread> cashiers = new ArrayList<>();

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 2; i++) {
            service.execute(new Cashier(i));
        }

        while (!Controller.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(2);
            for (int j = 1; j <= count; j++) {
                if (Controller.allBuyersInShop())
                    break;
                Buyer buyer = Controller.addNewBuyer();
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
        service.shutdown();
        System.out.println("Магазин закрылся");
    }
}
