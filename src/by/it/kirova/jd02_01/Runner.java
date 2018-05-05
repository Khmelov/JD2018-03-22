package by.it.kirova.jd02_01;


import java.util.ArrayList;


public class Runner {
    static int numberBuyer = 0;
    static ArrayList<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        int k = 120;
        Goods goods = new Goods();
        int[] chart = new int[k];
        for (int i = 0; i < k; i++) {

            int t = i % 60;
            int buyersInTheShop;
            Util.sleep(1000);
            System.out.println("\nИтерация " + i + "\n");
            do {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    Buyer buyer = new Buyer(++numberBuyer, goods);
                    buyers.add(buyer);
                    buyer.start();
                }
                buyersInTheShop = getBuyersCountInTheShop();
                System.out.println("Покупателей в магазине: " + buyersInTheShop);
            } while (t < 30 ? buyersInTheShop < (t + 10) : buyersInTheShop <= 40 + (30 - t));
            chart[i] = buyersInTheShop;
        }
        while (getBuyersCountInTheShop() > 0) {
            Util.sleep(1000);
        }
        System.out.println("time\tcount");
        for (int i = 0; i < k; i++) {
            System.out.println(i + "\t\t" + chart[i]);
        }
    }

    public static int getBuyersCountInTheShop() {
        int count = 0;
        for (Buyer buyer : buyers) {
            if (buyer.getState() != Thread.State.TERMINATED)
                count++;
        }
        return count;

    }
}
