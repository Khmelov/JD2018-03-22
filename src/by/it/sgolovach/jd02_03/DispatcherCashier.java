package by.it.sgolovach.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DispatcherCashier extends Thread {

    @Override
    public void run() {

        int countCashier = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(countCashier);

        for (int i = 1; i <= countCashier; i++) {
            executorService.execute(new Cashier(i));
        }

        executorService.shutdown();

    }
}
