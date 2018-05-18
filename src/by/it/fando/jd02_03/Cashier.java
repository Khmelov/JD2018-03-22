package by.it.fando.jd02_03;

public class Cashier implements Runnable {

    private int number;
    Cashier (int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу.");

        while (!Controller.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();
            if (buyer != null) {
                System.out.println(this + ". Начало обслуживания: " + buyer);
                Util.sleep(Util.random(2000, 5000));
                System.out.println(this + ". Конец обслуживания: " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(100);
        }
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }
}
