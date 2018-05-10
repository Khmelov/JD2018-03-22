package by.it.kovko.jd02_03;

import java.util.PriorityQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class CustomersQueue {
    private PriorityBlockingQueue<Customer> queue = new PriorityBlockingQueue<>(30);
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
            queue.put(customer);
            customer.setQueueingTime();
            ++length;
            if (shop.getWorkingCashierCount()*5< getLength() && shop.getWorkingCashierCount()<shop.CASHIERS_MAX){
                wakeCashier();
            }
    }
    Customer getCustomer(){
            --length;
            return queue.poll();
    }

}
