package by.it.pashkevich.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Runner {

    public static void main(String[] args) {
        Dispatcher.createKass();


        Dispatcher.createBuer();

        for (Map.Entry<Cashier, Thread> s : Dispatcher.cashiersThread.entrySet()) {
            try {
                s.getValue().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread.yield();
        System.out.println("Магазин закрылся");

        for (Map.Entry ent : Dispatcher.cashiers.entrySet()) {
            Cashier cashier = (Cashier) ent.getKey();
            System.out.print(String.format("|%20s|", cashier.toString()));
        }
        System.out.println();
        HashMap<Buyer, Cashier> buyerKass = Dispatcher.buyerKass;
        while (buyerKass.size() != 0) {
            for (Map.Entry ent : Dispatcher.cashiers.entrySet()) {
                Cashier cashier = (Cashier) ent.getKey();
                int find = 0;

                for (Map.Entry entry : buyerKass.entrySet()) {
                    Buyer buyer = (Buyer) entry.getKey();
                    Cashier cashier1 = (Cashier) entry.getValue();
                    if (cashier.equals(cashier1)) {
                        find = 1;
                        System.out.print(String.format("|%20s|", buyer.getNameBuyer() + ": " + buyer.getTotalMoney()));
                        buyerKass.remove(entry.getKey());
                        break;
                    }
                }
                if (find == 0) System.out.print(String.format("|%20s|", "----"));
            }
            System.out.println();
        }
    }
}
