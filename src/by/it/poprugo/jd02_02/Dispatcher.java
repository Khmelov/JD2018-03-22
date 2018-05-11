package by.it.poprugo.jd02_02;

public class Dispatcher {

    private static int numberBuyer = 0; //перенесли из Buyer //счетчик покупателей

    final static int planCount=10; //сколько покупателей нужно всего
    private static int processCount = 0; //сколько покупателей в магазине
    private static int factCount=0; //сколько вышло из магазина

    /*можно все 3 метода сделать synchronized, но пока 1 метод работает, остальные - в блокировке
     * т.е. - полностью однопоточка */
    //синхронизация происходит по классу Dispatcher.class (для каждого метода с synchronized)
    static boolean planCompete() { //когда planCompete - всё завершается
        return factCount>=planCount;
    }

    static Buyer addNewBuyer() {
        processCount++;
        return new Buyer(++numberBuyer);
    }

    static void finalBuyer() {
        processCount--;
        factCount++;
    }

    synchronized static boolean allBuyersInShop() {
        return numberBuyer==planCount; //д.б. >=?
    }
}
