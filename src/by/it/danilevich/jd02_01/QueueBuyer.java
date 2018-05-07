package by.it.danilevich.jd02_01;

import java.util.LinkedList;
import java.util.ListIterator;

class QueueBuyer {
    static LinkedList<Buyer> queue = new LinkedList<>();
    static void addbuyer(Buyer buyer){
        queue.addLast(buyer);
    }
    static void extractByuer(Buyer buyer){
        queue.pollFirst();
        System.out.println("Спасибо за покупку " + buyer.getNameBuyer());
    }
    static void printQueue(){
        String queuqS;
        ListIterator<Buyer> list = queue.listIterator();
        if (list.hasNext()) queuqS = "Текущая очередь ";
        else queuqS = "Свободная касса!!!!!!! ";
        while (list.hasNext()){
            Buyer elem =list.next();
            queuqS = queuqS.concat(elem.getNameBuyer()) +" ";
        }
        System.out.println(queuqS);
    }

    static Buyer getFirst(){
        ListIterator<Buyer> list = queue.listIterator();
        if (list.hasNext()){
            return list.next();
         }
         return null;
    }
}
