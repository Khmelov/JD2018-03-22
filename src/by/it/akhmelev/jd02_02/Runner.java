package by.it.akhmelev.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    static List<Thread> cashiers = new ArrayList<>();

    public static void main(String[] args) {
        //создали кассиров (чтобы было видно очередь сделаем их два
        for (int i = 1; i <= 2; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier);
            cashier.start();
        }

        //создаем покупателей пока не выполнен план
        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(2);
            //System.out.println("count=" + count);
            for (int j = 1; j <= count; j++) {
                if (Dispatcher.allBuyersInShop())
                    break;
                Buyer buyer = Dispatcher.addNewBuyer();
                buyer.start();
            }
        }

        //ожидаем закрытия последней кассы
        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //отдаем управление потоком для завершения выводов покупателей
        Thread.yield();
        System.out.println("Магазин закрылся");
    }
}
