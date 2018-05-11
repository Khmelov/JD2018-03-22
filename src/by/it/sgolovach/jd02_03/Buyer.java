package by.it.sgolovach.jd02_03;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer {

    private static Semaphore semaphore = new Semaphore(20);

    static Semaphore semaphoreBacket = new Semaphore(50);

    private final static Integer monitor1 = 0;

    int numberBuyer = 0;

    boolean pensioner() {
        if (numberBuyer % 4 == 0) return true;
        else return false;
    }


    @Override
    public void run() {
        enterToShop();
        System.out.println(this + "ждет свободной корзины");
        try {
            semaphoreBacket.acquire();
            takeBacket();
            System.out.println(this + "ждет входа в торговый зал");
            try {
                semaphore.acquire();
                System.out.println(this + "вошел в торговый зал");
                chooseGoods();
                putGoodsToBacket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            goQueue();
            goOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreBacket.release();
        }
    }


    private String name;


    @Override
    public void enterToShop() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBacket() {
        if (!pensioner()) {
            Util.sleep(Util.random(100, 200));
        } else {
            Util.sleep(Util.random(150, 300));
        }
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        if (!pensioner()) {
            Util.sleep(Util.random(500, 2000));
        } else {
            Util.sleep(Util.random(750, 3000));
        }
        synchronized (monitor1) {
            int count = Util.random(1, 4);
            ArrayList<String> goods = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                int countGood = Util.random(0, 9);
                goods.add(Runner.goodCatalague.get(countGood));
            }
            System.out.println(this + "выбрал товар");
            BacketBuyers.backetByuer(numberBuyer, goods);
        }
    }

    @Override
    public void putGoodsToBacket() {
        if (!pensioner()) {
            Util.sleep(Util.random(100, 200));
        } else {
            Util.sleep(Util.random(150, 300));
        }
        String str = "";
        synchronized (monitor1) {
            for (Object o : BacketBuyers.backetBuyer.get(numberBuyer)) {
                str += o + " ";
            }
        }
        System.out.println(this + "положил " + str + "в корзину");
    }

    @Override
    public void goQueue() {
        System.out.println(this + " встал в очередь");

        QueueBuyer.addInQueue(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазин");
//        DispatcherBuyer.countBuyersGoOut.incrementAndGet();
        if (QueueBuyer.sizeQueueRemove.get() == DispatcherBuyer.countBuyers) {
            DispatcherCashier.executorService.shutdown();
            Util.sleep(1000);
            System.out.println("Обслужено клиентов:" + QueueBuyer.sizeQueueRemove.get());
            System.out.println("Длина очереди:" + QueueBuyer.sizeQueueInAdd.get());
            System.out.println("Выручка магазина:" + Cashier.countShop);
            System.out.println("Магазин закрылся!!!");
        }
    }


    @Override
    public String toString() {
        return name + " ";
    }

    public Buyer(int number) {
        numberBuyer = number;
        if (pensioner()) {
            name = "Покупатель № " + number + " пенсионер";
        } else name = "Покупатель № " + number;
    }
}
