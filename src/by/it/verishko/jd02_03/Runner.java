package by.it.verishko.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    static List<Thread> buyersThread = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 5; i++) {
            service.execute(new Cashier(i));
        }

        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(2);
            System.out.println("count=" + count);
            for (int j = 0; j <= count; j++) {
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
        Thread.yield();
        System.out.println("Магазин закрылся");
        service.shutdown();
    }
}
