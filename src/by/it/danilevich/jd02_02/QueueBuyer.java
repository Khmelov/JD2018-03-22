package by.it.danilevich.jd02_02;

import java.util.Iterator;
import java.util.LinkedList;

class QueueBuyer {
    private static LinkedList<Buyer> queue = new LinkedList<>();
    private String name;

    public QueueBuyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void addbuyer(Buyer buyer){
        synchronized (queue) {
            String s = "Очередь " + getName() + getSize()+" чел.\n";
            queue.addLast(buyer);
            //LinkedList<Buyer> queue1 = getQueue();
           // printQueue(s + buyer.getNameBuyer() + " встал в очередь " + getName(), queue);
        }
    }
    public int getSize(){
        return queue.size();
    }

    Buyer extractByuer(){
        synchronized (queue) {
            if (queue.size() != 0) {
                return queue.pollFirst();
            }
            return null;
        }
    }
    void removeByuer(Buyer buyer){
        synchronized (queue) {
            if (queue.size() != 0) {
                queue.remove(buyer);
                String s = "Очередь " + getName() + getSize()+" чел.\n";
              //  LinkedList<Buyer> queue1 = getQueue();
             //   printQueue(buyer + " удалили из очереди "+getName(),queue);
            }
        }
    }
    private static LinkedList<Buyer> getQueue(){
        return queue;
    }
    public boolean contains(Buyer buyer){
        return queue.contains(buyer);
    }



    public void printQueue(String addString,LinkedList<Buyer> queue1){
            String queuqPrint = "";
            Iterator<Buyer> list = queue1.listIterator();
            queuqPrint = "Очередь "+getName() + queue1.size() +"чел.:";
            while (list.hasNext()) {
                Buyer elem = list.next();
                queuqPrint = queuqPrint.concat(elem.getNameBuyer()) + " ";
            }
            System.out.println(addString+ "\n" +queuqPrint);
      }

}
