package by.it.sgolovach.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Cashier extends Thread implements ICashier {

    private String name;

    int numberCashier = 0;

    final static AtomicInteger countShop = new AtomicInteger(0);

    @Override
    public void run() {
        if (numberCashier == 1) {
            while (!testQueue()) {
                if (QueueBuyer.sizeQueue() >= 1) {
                    open();
                    while (QueueBuyer.sizeQueue() >= 1) {
                        serviceBuyer();
                    }
                    close();
                }
            }
        }
        if (numberCashier == 2) {
            while (!testQueue()) {
                if (QueueBuyer.sizeQueue() > 5) {
                    open();
                    while (QueueBuyer.sizeQueue() > 5) {
                        serviceBuyer();
                    }
                    close();
                }
            }
        }
        if (numberCashier == 3) {
            while (!testQueue()) {
                if (QueueBuyer.sizeQueue() > 10) {
                    open();
                    while (QueueBuyer.sizeQueue() > 10) {
                        serviceBuyer();
                    }
                    close();
                }
            }
        }
        if (numberCashier == 4) {
            while (!testQueue()) {
                if (QueueBuyer.sizeQueue() > 15) {
                    open();
                    while (QueueBuyer.sizeQueue() > 15) {
                        serviceBuyer();
                    }
                    close();
                }
            }
        }
        if (numberCashier == 5) {
            while (!testQueue()) {
                if (QueueBuyer.sizeQueue() > 20) {
                    open();
                    while (QueueBuyer.sizeQueue() > 20) {
                        serviceBuyer();
                    }
                    close();
                }
            }
        }


    }

    @Override
    public void open() {
        System.out.println(this + " открыл кассу");
    }

    @Override
    public void serviceBuyer() {
        Buyer buyer = QueueBuyer.removeOfQueue();

        int countGoods = 0;
        String nameGoods = "";
        int countQueue = QueueBuyer.sizeQueue();

        for (Object keyGoods : BacketBuyers.backetBuyer.get(buyer.numberBuyer)) {
            if (numberCashier == 1) {
                nameGoods += keyGoods + "=" + Runner.goods.get(keyGoods) + "\n";
                countGoods += Runner.goods.get(keyGoods);
            }
            if (numberCashier == 2) {
                nameGoods += "                      " + keyGoods + "=" + Runner.goods.get(keyGoods) + "\n";
                countGoods += Runner.goods.get(keyGoods);
            }
            if (numberCashier == 3) {
                nameGoods += "                                              " + keyGoods + "=" + Runner.goods.get(keyGoods) + "\n";
                countGoods += Runner.goods.get(keyGoods);
            }
            if (numberCashier == 4) {
                nameGoods += "                                                                    " + keyGoods + "=" + Runner.goods.get(keyGoods) + "\n";
                countGoods += Runner.goods.get(keyGoods);
            }
            if (numberCashier == 5) {
                nameGoods += "                                                                                          " + keyGoods + "=" + Runner.goods.get(keyGoods) + "\n";
                countGoods += Runner.goods.get(keyGoods);
            }
        }


        countShop.getAndAdd(+countGoods);


        if (numberCashier == 1) {
            Util.sleep(Util.random(2000, 5000));
            System.out.println(this + " start\n" + buyer.toString());
            System.out.println("Чек №" + buyer.numberBuyer + "\n" + nameGoods + "Итого= " + countGoods);
            System.out.println("                                                                                                                               Размер очереди:" + countQueue + "              Выручка:" + countShop.get());
            System.out.println(this + " finish");
        }
        if (numberCashier == 2) {
            Util.sleep(Util.random(2000, 5000));
            System.out.println("                      " + this + " start\n                      " + buyer.toString());
            System.out.println("                      Чек №" + buyer.numberBuyer + "\n" + nameGoods + "                      Итого= " + countGoods);
            System.out.println("                                                                                                                               Размер очереди:" + countQueue + "              Выручка:" + countShop.get());
            System.out.println("                      " + this + " finish");
        }
        if (numberCashier == 3) {
            Util.sleep(Util.random(2000, 5000));
            System.out.println("                                              " + this + " start\n                                              " + buyer.toString());
            System.out.println("                                              Чек № " + buyer.numberBuyer + "\n" + nameGoods + "                                              Итого= " + countGoods);
            System.out.println("                                                                                                                               Размер очереди:" + countQueue + "              Выручка:" + countShop.get());
            System.out.println("                                              " + this + " finish\n                                              " + buyer.toString());
        }
        if (numberCashier == 4) {
            Util.sleep(Util.random(2000, 5000));
            System.out.println("                                                                    " + this +
                    " satrt\n                                                                    " + buyer.toString());
            System.out.println("                                                                    Чек № " + buyer.numberBuyer + "\n" + nameGoods +
                    "                                                                    Итого= " + countGoods);
            System.out.println("                                                                                                                               Размер очереди:" + countQueue + "              Выручка:" + countShop.get());
            System.out.println("                                                                    " + this +
                    " finish\n                                                                    " + buyer.toString());
        }
        if (numberCashier == 5) {
            Util.sleep(Util.random(2000, 5000));
            System.out.println("                                                                                          " + this +
                    " start\n                                                                                          " + buyer.toString());
            System.out.println("                                                                                          Чек № " + buyer.numberBuyer + "\n" + nameGoods +
                    "                                                                                          Итого= " + countGoods);
            System.out.println("                                                                                                                               Размер очереди:" + countQueue + "              Выручка:" + countShop.get());
            System.out.println("                                                                                          " + this +
                    " finish\n                                                                                          " + buyer.toString());
        }

        synchronized (buyer){
            buyer.notify();
        }

        Buyer.semaphoreBacket.release();

    }


    @Override
    public void close() {
        System.out.println(this + " закрыл кассу");
    }

    public boolean testQueue() {
            return QueueBuyer.sizeQueueRemove.get() == DispatcherBuyer.countBuyers;
    }

    public Cashier(int number) {
        numberCashier = number;
        name = "Кассир № " + number;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
