package by.it.shvedov.jd02_03;

import by.it.shvedov.jd02_01.Buyer;
import by.it.shvedov.jd02_01.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
//ExecutorService service= Executors.newFixedThreadPool(5);
 //for(int i=0; i<=2; i++){

   // }
   // private static void sleep(int s) {
     //   try {
       //     Thread.sleep(s);
       // } catch (Inter ruptedException e) {
       //     e.printStackTrace();
       // }
   // }
}
