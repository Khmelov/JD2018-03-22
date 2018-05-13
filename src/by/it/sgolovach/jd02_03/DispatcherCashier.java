package by.it.sgolovach.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DispatcherCashier extends Thread {

    static ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Override
    public void run() {


        executorService.execute(new Cashier(1));
        executorService.execute(new Cashier(2));
        executorService.execute(new Cashier(3));
        executorService.execute(new Cashier(4));
        executorService.execute(new Cashier(5));


//        executorService.shutdown();

    }
}
