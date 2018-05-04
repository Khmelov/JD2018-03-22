package by.it.verishko.jd02_01;

import static java.lang.Thread.sleep;

public class Runner {
    static int numberBuyer = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Util.sleep(500);
            int count = (int) (Math.random() * 3);
            for (int j = 0; j <= count; j++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
            }
        }
    }
}
