package by.it.volchek.jd02_01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by volchek on 26.04.18.
 */
public class QueueBuyer {
    private static LinkedList<Buyer> internalQueue = new LinkedList<>();
    static void addBuyer(Buyer buyer){
        internalQueue.addLast(buyer);

    }
    static Buyer extractBuyer (){
        return internalQueue.pollFirst();
    }
}
