package by.it.poprugo.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    static List<Thread> buyerThread = new ArrayList<>();
    //static List<Thread> cashiers = new ArrayList<>(); - было до использования ExecutorService


    public static void main(String[] args) {
    //создаем покупателей пока не выполнен план
        while (!Dispatcher.allBuyersInShop()) {
            Util.sleep(1000);
            int count = Util.random(2);
            System.out.println("count=" + count);
            for (int j = 0; j < count; j++) {
                if (Dispatcher.allBuyersInShop())
                    break;
                Buyer buyer = Dispatcher.addNewBuyer();
                buyerThread.add(buyer);
                //buyer.start(); - если бы не было этого в Buyer
            }
        }
    //создали кассиров (чтобы было видно очередь сделаем их два/пять)
        ExecutorService service = Executors.newFixedThreadPool(5);
            /*Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier); //???
            cashier.start(); - было до 8 мая */
        for (int i = 0; i < 2; i++) {
            service.execute(new Cashier(i));
        }

        for (Thread buyer : buyerThread) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } // когда все затерминируются, то перейдём к следующему этапу: "магазин закрылся"
        //Thread.yield();
        // если sleep, то гарантировано эта строка выведется последней, а если yield - то гарантии нет
    //отдаем управление потоком для завершения выводов покупателей
        Util.sleep(500); //тут нужно подождать дольше чем любой из кассиров
        System.out.println("магазин закрылся");
        service.shutdown();
    }
}
