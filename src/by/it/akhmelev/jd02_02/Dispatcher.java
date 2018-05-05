package by.it.akhmelev.jd02_02;

class Dispatcher {

    static int speed = 25; //во сколько раз ускорить приложение
    private final static int planCount = 100; //сколько покупателей нужно всего

    private static int numberBuyer = 0; //счетчик покупателей
    private static int processCount = 0; //сколько их в магазине
    private static int factCount = 0;  //сколько вышло из магазина

    //синхронизация происходит по объекту Dispatcher.class
    synchronized static boolean planComplete() {
        return factCount >= planCount;
    }

    //синхронизация происходит по объекту Dispatcher.class
    synchronized static Buyer addNewBuyer() {
        processCount++;
        return new Buyer(++numberBuyer);
    }

    //синхронизация происходит по объекту Dispatcher.class
    synchronized static void finalBuyer() {
        processCount--;
        factCount++;
    }

    //синхронизация происходит по объекту Dispatcher.class
    synchronized static boolean allBuyersInShop() {
        return numberBuyer == planCount;
    }


}
