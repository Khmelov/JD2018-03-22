package by.it.sgolovach.jd02_02;

public class Cashier implements Runnable {

    private int number;


    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();
            if (buyer != null) {
                System.out.println(this + " начало обслуживания " + buyer);
                Util.sleep(Util.random(2000, 5000));
                System.out.println(this + " завершил обслуживания " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Util.sleep(100);
        }
    }

    @Override
    public String toString() {
        return "Cashier№" + number + " ";
    }
}
