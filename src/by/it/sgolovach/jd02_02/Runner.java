package by.it.sgolovach.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    static List<String> goodCatalague = new ArrayList<>();

    static Map<String, Integer> goods = new HashMap<>();

    static List<Thread> cashiers = new ArrayList<>();


    public static void main(String[] args) {

        goodCatalague.add("хлеб");
        goodCatalague.add("вода");
        goodCatalague.add("молоко");
        goodCatalague.add("колбаса");
        goodCatalague.add("консервы");
        goodCatalague.add("булочка");
        goodCatalague.add("мясо");
        goodCatalague.add("йогурт");
        goodCatalague.add("шоколад");
        goodCatalague.add("макароны");

        goods.put("хлеб", 5);
        goods.put("вода", 10);
        goods.put("молоко", 6);
        goods.put("колбаса", 20);
        goods.put("консервы", 15);
        goods.put("булочка", 2);
        goods.put("мясо", 25);
        goods.put("йогурт", 4);
        goods.put("шоколад", 7);
        goods.put("макароны", 12);

        for (int i = 1; i <= 6; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier);
            cashier.start();
        }


        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(5);
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
        System.out.println("Магазин закрылся");


    }
}
