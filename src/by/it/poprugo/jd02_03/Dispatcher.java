package by.it.poprugo.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static int speed = 25; //переменная, кот.увеличивает скорость работы приложения
    //private static int numberBuyer = 0; //перенесли из Buyer //счетчик покупателей
    private final static AtomicInteger  numberBuyer = //AtomicInteger - потокобезопасный счётчик
            new AtomicInteger(0);

    private final static int planCount=10; //сколько покупателей нужно всего (10)

    private static int processCount = 0; //сколько покупателей в магазине

    private final static AtomicInteger  factCount = //сколько вышло из магазина
            new AtomicInteger(0);

    //синхронизация происходит по объекту Dispatcher.class (для каждого метода где был synchronized)
    static boolean planCompete() { //когда planCompete - всё завершается
        return factCount.get()>=planCount;
    }

    static Buyer addNewBuyer() {
        processCount++;
        return new Buyer(numberBuyer.addAndGet(1));
    }

    static void finalBuyer() {
        processCount--;
        factCount.addAndGet(1);
    }

    static boolean allBuyersInShop() { return numberBuyer.get()>=planCount; }
}
