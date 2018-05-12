package by.it.kirova.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static List<Thread> buyersThread = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("\nКАССИР №1           КАССИР №2           КАССИР №3           КАССИР №4           КАССИР №5           РАЗМЕР ОЧЕРЕДИ      ВЫРУЧКА МАГАЗИНА    \n");
        //создали кассиров (чтобы было видно очередь сделаем их два
        ExecutorService service= Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            service.execute(QueueBuyer.createCashier());
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
                buyersThread.add(buyer);
                buyer.start();
            }
        }

        //ожидаем закрытия последней кассы
        for (Thread buyer : buyersThread) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //отдаем управление потоком для завершения выводов покупателей
        Util.sleep(500); //тут нужно подождать дольше чем любой из кассиров
        System.out.println("Магазин закрылся");
        service.shutdown();
    }
}
