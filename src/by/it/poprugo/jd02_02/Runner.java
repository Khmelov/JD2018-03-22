package by.it.poprugo.jd02_02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Runner {
    static List<Thread> cashiers = new ArrayList<>();

    public static void main(String[] args) {

        /*for (int i = 0; i < 5; i++) { - было до создания коллекции кассиров
            new Thread (new Cashier(i)).start(); //всех этих кассиров можно сложить в коллекцию
        }*/
        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(2);
            System.out.println("count=" + count);
            for (int j = 0; j < count; j++) {
                if (Dispatcher.allBuyersInShop())
                    break;
                Buyer buyer = Dispatcher.addNewBuyer();
                // Buyer buyer = new Buyer(++numberBuyer);
                //buyer.start(); //? почему? если уже в Buyer есть start?
                //queue.add(buyer);
            }
        }
//создали кассиров (чтобы было видно очередь сделаем их два/пять
        for (int i = 0; i < 2; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier); //???
            cashier.start();
        }

        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("магазин закрылся");
    }
}
