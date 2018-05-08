package by.it.kovko.jd02_02;

import java.util.PriorityQueue;

public class CustomersQueue {
    private PriorityQueue<Customer> queue = new PriorityQueue<>();
    private int length =0;
    Shop shop;

    public CustomersQueue(Shop shop) {
        this.shop = shop;
    }
    public int getLength(){return length;}
    
    private void wakeCashier(){
        synchronized (ConcreteCashier.cashierMonitor){
            ConcreteCashier.cashierMonitor.notify();
        }
    }
    void putCustomer (Customer customer){
        synchronized (this) {
            queue.add(customer);
            customer.setQueueingTime();

            ++length;
//            System.out.println("Очередь:");
//            PriorityQueue<Customer> nqueue=new PriorityQueue<Customer>(queue);
//            for (int i = 0; i < length; i++) {
//                System.out.print(nqueue.poll().getName()+" ");
//            }
//            System.out.println("Конец очереди");
            if (shop.getWorkingCashierCount()*5< getLength() && shop.getWorkingCashierCount()<shop.CASHIERS_MAX){
                //System.out.println("В очереди " + length + " человек");
                wakeCashier();
            }
        }
    }
    Customer getCustomer(){
        synchronized (this) {
            --length;
            return queue.poll();
        }
    }

}
