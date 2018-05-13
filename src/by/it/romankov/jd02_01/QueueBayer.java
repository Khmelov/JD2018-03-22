package by.it.romankov.jd02_01;

import java.util.LinkedList;

class QueueBayer {
    private static LinkedList <Buyer> internalQueue = new LinkedList <>();

    static void addBayer(Buyer bayer) {
        for ( int i = 0; i < 120; i++ ) {
            internalQueue.add(bayer);
        }
                System.out.println("Extract " + extractBuyer());
            }


    static Buyer extractBuyer() {
        return internalQueue.pollFirst();
    }
}
