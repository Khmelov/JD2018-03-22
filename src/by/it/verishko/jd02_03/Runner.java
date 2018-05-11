package by.it.verishko.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    private static List<Thread> buyersThread = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            service.execute(new Cashier(i));
        }
        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(2);
            for (int j = 1; j <= count; j++) {
                if (Dispatcher.allBuyersInShop())
                    break;
                Buyer buyer = Dispatcher.addNewBuyer();
                buyersThread.add(buyer);
                buyer.start();
            }
        }
        for (Thread buyer : buyersThread) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Util.sleep(500);
        System.out.println("Магазин закрылся");
        service.shutdown();
    }
}
