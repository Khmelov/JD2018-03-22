package by.it.sgolovach.jd02_02;

public class Cashier implements Runnable {

    private int number;


    Cashier(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println(this + "открыл кассу.");
        while (!Dispatcher.planComplete()) {
            Buyer buyer = null;
            if (QueueBuyer.internalQueuePensioner.size() > 0) buyer = QueueBuyer.extractBuyerPensioner();
            else buyer = QueueBuyer.extractBuyer();
            if (buyer != null) {
                System.out.println(this + " начало обслуживания " + buyer);
                Util.sleep(Util.random(2000, 5000));
                System.out.println(this + " завершил обслуживания " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Util.sleep(100);
        }
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }
}
