package by.it.kovko.jd02_03;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Shop {

    private final AtomicInteger workingCashierCount = new AtomicInteger(0);
    private Semaphore customers = new Semaphore(20);
    private Semaphore carts = new Semaphore(40);
    //private volatile double shopTotal=0;
    public final int CASHIERS_MAX=5;
    public final int CUSTOMERS_MAX=100;
    public CountDownLatch customersLatch = new CountDownLatch(CUSTOMERS_MAX);
    private int maxCustomers=15;
    //private final Object totalMonitor= new Object();
    private int customerCount=0;
    public CustomersQueue q = new CustomersQueue(this);
    public final ExecutorService cashiers = Executors.newFixedThreadPool(CASHIERS_MAX);
    private final AtomicInteger activeCustomerCount = new AtomicInteger(0);
    public final AtomicInteger atomicTotal = new AtomicInteger(0);
    enum Goods{
        Молоко(1.33), Кефир(1.56), Хлеб(1.43), Сок(2.32), Масло(1.87),
        Колбаса(4.54), Кофе(3.54), Чай(3.43), Рыба(6.54), Консервы(3.21);
        private double price;
        double getPrice(){return price;}
        Goods(double price){this.price=price;}
    }

    public int getWorkingCashierCount() {
        return workingCashierCount.get();
    }
    public void addCashier(){
        workingCashierCount.incrementAndGet();
    }
    public void subCashier(){
        workingCashierCount.decrementAndGet();
    }

//    public double getShopTotal() {
//        synchronized (totalMonitor) {
//            return shopTotal;
//        }
//    }
//    public void addShopTotal(double shopTotal) {
//        synchronized (totalMonitor){
//            this.shopTotal += shopTotal;
//        }
//    }
    public void getCart(){
        try {
            carts.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void returnCart(){
        carts.release();
    }
    public void shopAcquire(){
        try {
            customers.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void shopRelease(){
        customers.release();
    }



    void open() {
        System.out.println("Магазин открылся");
        ExecutorService cashiers = Executors.newFixedThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = Executors.defaultThreadFactory().newThread(r);
                thread.setDaemon(true);
                return thread;
            }
        });
        for (int i = 1; i <= CASHIERS_MAX; i++) {
            cashiers.execute(new ConcreteCashier(i, this));
        }


        int sec=0, customers, k;
        while (customerCount < CUSTOMERS_MAX) {
            ++sec;
            k=(sec/30)%2;
            customers=10+30*k+(1-2*k)*sec%30- activeCustomerCount.get();
            if (customers>maxCustomers) customers=maxCustomers;
            if (customers<0) customers=0;
            for (int i=0;i<customers;++i) {
                ++customerCount;
                if (customerCount>CUSTOMERS_MAX) break;
                    if (Math.random() < 0.25)
                        new Thread(new Pensioner(customerCount, this)).start();
                    else
                        new Thread(new ConcreteCustomer(customerCount, this)).start();
            }
            Helper.sleep(100);
        }
        try {
            customersLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Магазин закрылся");

    }

}
