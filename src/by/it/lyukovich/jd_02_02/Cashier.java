package by.it.lyukovich.jd_02_02;

public class Cashier extends Thread {
    private int number;
    private boolean inWork= false;

    Cashier(int number) {
        this.number = number;
        this.setName("Кассир №" + number + " ");
    }

    @Override
    public String toString() {
        return "Кассир №" + number + " ";
    }

    @Override
    public void run() {
        boolean start= false;
        while (!Dispatcher.endCashiers()) {
            start = ShopRunner.allowWork(start);
            if (start) {
                if (!inWork) {
                    System.out.println(this + " Открыл кассу");
                    inWork = true;
                }
                Buyer buyer = QueueBuyer.extractBuyer();
                if (buyer != null) {
                    System.out.println(this + "начал обслуживание: " + buyer);
                    Util.sleep(Util.random(2000, 5000));
                    System.out.println(this + "завершил обслуживание: " + buyer);
                    synchronized (buyer) {
                        buyer.notify();
                    }
                } else {
                    inWork = false;
                    ShopRunner.cashierOnDutyRemove();
                    start = false;
                    System.out.println(this + "Закрыл кассу!!!!!!!");

                }
            }
        }
        System.out.println(this + " закончил работу");
    }
}
