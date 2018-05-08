package by.it.danilevich.jd02_02;

import java.util.LinkedList;
import java.util.ListIterator;

class QueueBuyer {
    private static LinkedList<Buyer> queue = new LinkedList<>();
    void addbuyer(Buyer buyer){
        queue.addLast(buyer);
    }
    public int getSize(){
        return queue.size();
    }

    Buyer extractByuer(){
        if (queue.size()!=0){
            return queue.pollFirst();
        }
        return null;
    }
    void removeByuer(Buyer buyer){
        if (queue.size()!=0){
            queue.remove(buyer);
        }
    }
    public boolean contains(Buyer buyer){
        return queue.contains(buyer);
    }



    static void printQueue(){
        String queuqPrint="";
        ListIterator<Buyer> list = queue.listIterator();
        if (list.hasNext()) queuqPrint = "Общая очередь ";
        while (list.hasNext()){
            Buyer elem =list.next();
            queuqPrint = queuqPrint.concat(elem.getNameBuyer()) +" ";
        }
        System.out.println(queuqPrint);
    }

    static Buyer getFirst(){
        ListIterator<Buyer> list = queue.listIterator();
        if (list.hasNext()){
            return list.next();
         }
         return null;
    }
}
