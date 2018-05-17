package by.it.pashkevich.jd02_02;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private ArrayList<Buyer> buyersInCashier = new ArrayList<>();
    private int num;

    Cashier(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Касса №" + num;
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            if (buyersInCashier.size() < 5) {
                Buyer buyer;
                synchronized (Dispatcher.buyersInQueuq) {
                    buyer = Dispatcher.buyersInQueuq.extractByuer();

                    //покупатель найден и в кассу можно заходить
                    if (buyer != null && Dispatcher.cashiers.get(this) != "block") {
                        //
                        Dispatcher.openKass(this);
                        Util.sleep(1);
                        addBueyrToKass(buyer);
                        printByer();
                        System.out.println(this + ". Начало обслуживания для объекта: " + buyer);

                        Dispatcher.buyersInKass.addbuyer(buyer);
                        Util.sleep(Util.random(2000, 5000));
                        System.out.println(this + ". Конец обслуживания  для объекта: " + buyer);
                        Dispatcher.buyerKass.put(buyer, this);
                        removeBueyrFromKass(buyer);
                        Dispatcher.buyersInKass.removeByuer(buyer);
                        synchronized (buyer) {
                            buyer.notify();
                        }

                    } else Util.sleep(1000);
                }
            }

        }
    }

    private void addBueyrToKass(Buyer buyer) {
        synchronized (buyersInCashier) {
            if (buyersInCashier.size() <= Dispatcher.getMaxByerInCashier()) {
                buyersInCashier.add(buyer);
                Dispatcher.buyersInKass.addbuyer(buyer);
                Dispatcher.buyersInQueuq.removeByuer(buyer);
            }
        }


    }

    private void removeBueyrFromKass(Buyer buyer) {
        synchronized (buyersInCashier) {
            buyersInCashier.remove(buyer);
        }
    }

    private void printByer() {
        String linePrint = "Касса №" + num + ": ";
        for (Buyer buyer : buyersInCashier) {
            linePrint = linePrint.concat(buyer.getNameBuyer()) + "|";
        }
        System.out.println(linePrint);

    }


}
