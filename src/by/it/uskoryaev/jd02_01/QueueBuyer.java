package by.it.uskoryaev.jd02_01;

import java.util.LinkedList;

public class QueueBuyer {
    private static LinkedList<Buyer> internalQueue = new  LinkedList<>();

    static void addBuyer(Buyer buyer){
        internalQueue.addLast(buyer);
        if (Math.random()>0.5){
            System.out.println();
            extractBuyer();
        }
    }
    static  Buyer extractBuyer(){
        return internalQueue.pollFirst();
    }
}
