package by.it.kovko.jd02_02;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Shop {

    private volatile int workingCashierCount = 0;

    public double getShopTotal() {
        synchronized (totalMonitor) {
            return shopTotal;
        }
    }

    public void addShopTotal(double shopTotal) {
        synchronized (totalMonitor){
            this.shopTotal += shopTotal;
        }
    }

    private volatile double shopTotal=0;

    public int getWorkingCashierCount() {
        return workingCashierCount;
    }
    public void addCashier(){
        synchronized (cashierCounterMonitor) {
            ++workingCashierCount;
        }
    }
    public void subCashier(){
        synchronized (cashierCounterMonitor) {
            --workingCashierCount;
        }
    }
    public void addCustomer(){
        synchronized (customerCounterMonitor){
            ++activeCustomerCount;
        }
    }
    public void subCustomer(){
        synchronized (customerCounterMonitor){
            --activeCustomerCount;
        }
    }
    enum Goods{
        Молоко(1.33), Кефир(1.56), Хлеб(1.43), Сок(2.32), Масло(1.87),
        Колбаса(4.54), Кофе(3.54), Чай(3.43), Рыба(6.54), Консервы(3.21);
        private double price;
        double getPrice(){return price;}
        Goods(double price){this.price=price;}
    }

    public Object getCashierCounterMonitor() {
        return cashierCounterMonitor;
    }
    public final int CASHIERS_MAX=5;
    public final int CUSTOMERS_MAX=100;
    private int maxCustomers=15;
    private final Object cashierCounterMonitor= new Object();
    private final Object customerCounterMonitor= new Object();
    private final Object totalMonitor= new Object();
    private int customerCount=0;
    volatile private int activeCustomerCount=0;
    volatile private int workingCashiersCount=0;
    private ArrayList<Thread> customersThreads = new ArrayList<>();


    CustomersQueue q = new CustomersQueue(this);
    void open() {
        System.out.println("Магазин открылся");

        for (int i = 1; i <= CASHIERS_MAX; i++) {

            Thread t = new Thread(new ConcreteCashier(i, this));
            t.setDaemon(true);
            t.start();
        }
        Thread t;

        int sec=0, customers, k;
        while (customerCount < CUSTOMERS_MAX) {
            ++sec;
            k=(sec/30)%2;
            customers=10+30*k+(1-2*k)*sec%30- activeCustomerCount;
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (customers>maxCustomers) customers=maxCustomers;
            if (customers<0) customers=0;
            for (int i=0;i<customers;++i) {
                ++customerCount;
                if (customerCount>CUSTOMERS_MAX) break;
                    if (Math.random() < 0.25)
                        t = new Thread(new Pensioner(customerCount, this));
                    else
                        t = new Thread(new ConcreteCustomer(customerCount, this));
                    customersThreads.add(t);
                    t.start();
            }
            Helper.sleep(1000);
        }
        for (Thread customersThread : customersThreads) {
            try {
                customersThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрылся");
    }

}
