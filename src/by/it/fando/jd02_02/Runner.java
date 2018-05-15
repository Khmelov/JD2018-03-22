package by.it.fando.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static List<Thread> cashiers = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier);
            cashier.start();
        }

        while (!Controller.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(5);
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
        System.out.println("Магазин закрылся");
    }
}
