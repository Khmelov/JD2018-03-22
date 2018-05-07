package by.it.desykevich.jd02_02;

import by.it.akhmelev.jd02_01.Buyer;

import java.util.LinkedList;

class QueueBuyer {

    private final static LinkedList<Buyer> internalQueue=new LinkedList<>();

    static void addBuyer(Buyer buyer){
        synchronized (internalQueue){
            internalQueue.addLast(buyer);
        }

    }

    static Buyer extractBuyer(){

        return internalQueue.pollFirst();
    }

}
