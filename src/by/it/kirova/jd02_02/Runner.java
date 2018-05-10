package by.it.kirova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Thread> cashierThreads = new ArrayList<>();

        //создали кассиров (чтобы было видно очередь сделаем их два
        for (int i = 1; i <= 5; i++) {
            Thread cashier = new Thread(QueueBuyer.createCashier());
            cashierThreads.add(cashier);
            cashier.start();
        }

        int i = 0;
        while (!Dispatcher.allBuyersInShop()) {
            do {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    Buyer buyer = Dispatcher.addNewBuyer();
                    buyer.start();
                }
            } while (Dispatcher.needNext(i));
            Util.sleep(1000);
            i++;
        }

        //ожидаем закрытия последней кассы
        for (Thread cashier : cashierThreads) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //отдаем управление потоком для завершения выводов покупателей
        Thread.yield();

        Printer.printMessage("Магазин закрылся");
    }
}
