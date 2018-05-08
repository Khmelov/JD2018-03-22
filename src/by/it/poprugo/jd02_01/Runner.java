package by.it.poprugo.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.Thread.sleep;

public class Runner {
    static int numberBuyer = 0;
    public static void main(String[] args) {
        Queue<Buyer> queue = new ArrayDeque<>(); //the general Buyers queue
        /*for (int i = 0; i < 10; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int count = (int) (Math.random()*3);

            for (int j = 0; j < =count; j++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
            }

        }*/
        for (int i = 0; i < 10; i++) {
            Util.sleep(50);
            int count = Util.random(2);
            System.out.println("count=" + count);
            for (int j = 0; j < count; j++) {
                Buyer buyer = new Buyer(++numberBuyer);
                //buyer.start(); ? почему? если уже в Buyer есть start?
                queue.add(buyer);
            }
        }
    }
}
