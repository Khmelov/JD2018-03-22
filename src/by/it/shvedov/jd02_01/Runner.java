package by.it.shvedov.jd02_01;

import static java.lang.Thread.sleep;

    public class Runner {
        static int numberByuer=0;
    public static void main(String[] args) {
        for (int i = 0; i <20 ; i++) {
            int s=500;
            Util.sleep(s);
            int count=(int)(Math.random()*3);
            for (int j = 0; j <count ; j++) {
                Buyer buyer = new Buyer(++numberByuer);
                buyer.start();
            }
        }
    }

       // private static void sleep(int s) {
         //   try {
           //     Thread.sleep(s);
           // } catch (Inter ruptedException e) {
           //     e.printStackTrace();
           // }
       // }
    }
