package by.it.sgolovach.jd02_01;

import java.util.LinkedList;

class QueueBuyer {

  static LinkedList<Buyer> internalQueue = new LinkedList<>();


    static void addBuyer(Buyer buyer) {
        System.out.println(buyer + " стал в очередь");
        internalQueue.addLast(buyer);
    }


}
