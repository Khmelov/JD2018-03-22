package by.it.uskoryaev.jd02_01;

import java.util.LinkedList;

public class QueueBuyer {
     private static LinkedList<Buyer> internalQueue = new LinkedList<>();

     static void addBuyer(Buyer buyer){
         for (int i = 0; i < 100; i++) {
             internalQueue.addLast(buyer);
         }
         if (Math.random()>0.5)
             for (int i = 0; i < 100; i++) {
                 System.out.println("Extract"+extractBuyer());
             }
     }
     static Buyer extractBuyer(){return internalQueue.pollFirst();}
}
