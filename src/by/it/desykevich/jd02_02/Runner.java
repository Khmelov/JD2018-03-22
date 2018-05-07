package by.it.desykevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Queue;


public class Runner {

    static Queue<Buyer> queue = new ArrayDeque<>();


    public static void main(String[] args) {
        for (int second = 0; second < 50; second++) {
            int count = Util.random(2);
            for (int i = 0; i <= count; i++) {
                Buyer b = Dispatcher.addnewBuyer();
                b.start();
                queue.add(b);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (queue.size() > 0) {
            for (Buyer buyer : queue) {
                try {
                    buyer.join();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Все вышли, магазин закрыт.");
    }


}
