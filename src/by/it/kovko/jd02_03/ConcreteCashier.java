package by.it.kovko.jd02_03;

import java.util.Map;

public class ConcreteCashier implements Cashier, Runnable{

    public static final Object cashierMonitor = new Object();
    private String name;
    private int index;
    private Shop shop;
    ConcreteCashier(int i, Shop shop){
        index=i;
        name="Касса №"+i;
        this.shop=shop;
    }
    @Override
    public void fetchCustomer() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Customer c = shop.q.getCustomer();
        if (c!=null)
            synchronized (cashierMonitor) {
                synchronized (c) {
                    double total = 0;
                    double d;
                    Helper.identation(index);
                    System.out.printf("%-26s", "Касса №" + index);
                    Helper.whitespaces(index);
                    System.out.println("Размер очереди: " + (shop.q.getLength() + 1));
                    Helper.identation(index);
                    System.out.printf("%-26s", c.getName());
                    Helper.whitespaces(index);
                    System.out.println("Количество кассиров: " + shop.getWorkingCashierCount());
                    for (Map.Entry<Shop.Goods, Integer> goodsDoubleEntry : c.getShoppingList().entrySet()) {
                        d = Shop.Goods.valueOf(goodsDoubleEntry.getKey().toString()).getPrice() * goodsDoubleEntry.getValue();
                        total += d;
                        //shop.addShopTotal(d);
                        shop.atomicTotal.addAndGet((int)(d*100));
                        Helper.identation(index);
                        System.out.printf("%-11s - %2d x %5.2f", goodsDoubleEntry.getKey(),
                                goodsDoubleEntry.getValue(), Shop.Goods.valueOf(goodsDoubleEntry.getKey().toString()).getPrice());
                        Helper.whitespaces(index - 1);
                        //System.out.printf("%5.2f\n", shop.getShopTotal());
                        System.out.printf("%5.2f\n", shop.atomicTotal.get()*0.01);

                    }
                    Helper.identation(index);
                    System.out.printf("%-11s -      %5.2f", "Итог", total);
                    Helper.whitespaces(index - 1);
                    System.out.printf("%5.2f\n\n", shop.atomicTotal.get()*0.01);
                    c.notify();
                }
            }
    }

    @Override
    public void pause() {
        synchronized (cashierMonitor) {
            try {
                cashierMonitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while(true) {
            pause();
            shop.addCashier();
            while ((shop.getWorkingCashierCount() - 1) * 5 < shop.q.getLength()) {
                fetchCustomer();
            }
            shop.subCashier();
        }
    }
}
