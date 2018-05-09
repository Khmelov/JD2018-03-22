package by.it.sgolovach.jd02_01;


import java.util.*;

public class Runner {

    static List<String> goodCatalague = new ArrayList<>();

    static Map<String, Integer> goods = new HashMap<>();

    static int countBuyers = 0;

    static int countBuyersInShop = 0;

    public static void main(String[] args) throws InterruptedException {

        goodCatalague.add("хлеб");goodCatalague.add("вода");goodCatalague.add("молоко");goodCatalague.add("колбаса");
        goodCatalague.add("консервы");goodCatalague.add("булочка");goodCatalague.add("мясо");goodCatalague.add("йогурт");
        goodCatalague.add("шоколад");goodCatalague.add("макароны");

        goods.put("хлеб", 5);goods.put("вода", 10);goods.put("молоко", 6);goods.put("колбаса", 20);
        goods.put("консервы", 15);goods.put("булочка", 2);goods.put("мясо", 25);goods.put("йогурт", 4);
        goods.put("шоколад", 7);goods.put("макароны", 12);


        for (int i = 1; i < 121; i++) {
            Thread.sleep(1000);
            if (i == 1 || i == 60 && countBuyersInShop <= 10) {
                int count = Util.random(5, 10);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    countBuyers++;
                    Buyer buyer = new Buyer(countBuyers);
                    buyer.start();
                }
            }
            if (i > 1 && i < 31 && countBuyersInShop <= (i + 10) || i > 60 && i < 91 && countBuyersInShop <= (i + 10)) {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    countBuyers++;
                    Buyer buyer = new Buyer(countBuyers);
                    buyer.start();
                }
            }

            if (i > 30 && i < 61 && countBuyersInShop <= (40 + (30 - i)) || i > 90 && i < 121 && countBuyersInShop <= (40 + (30 - i))) {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    countBuyers++;
                    Buyer buyer = new Buyer(countBuyers);
                    buyer.start();
                }
            }
        }




    }
}


