package by.it.desykevich.jd02_02;

import java.util.Map;

public class Cashier implements Runnable {

    private int number;
    public volatile static double totalSum = 0;
    private static int numOfCashiers = 0;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        System.out.println(this + " открыл кассу.");
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();
            if (buyer != null) {
                System.out.println(this + ". Начало обслуживания для объекта: " + buyer);
                Util.sleep(Util.random(2000, 5000));
                System.out.println(this + " печатает чек для " + buyer + ".");
//                getSum(buyer);
//                System.out.println(this + ". Конец обслуживания  для объекта: " + buyer);
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

//
//    private void getSum(Buyer buyer) {
//        double sum = 0.0;
//        for (Map.Entry<String, Double> good : buyer.getBasket().getGoodsInBasket().entrySet()) {
//            sum += good.getValue();
//        }
//        synchronized (Cashier.class) {
//            totalSum += sum;
//        }
//        System.out.println("Чек на сумму: " + sum);
//    }
}
