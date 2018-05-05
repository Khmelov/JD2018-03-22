package by.it.akhmelev.jd02_02;

class Dispatcher {

    private static int numberBuyer = 0;
    private final static int planCount=100;
    private static int processCount=0;
    private static int factCount=0;

    //синхронизаия происходит по классу Dispatcher.class
    synchronized static boolean planComplete(){
        return factCount>=planCount;
    }

    synchronized static Buyer addNewBuyer(){
        processCount++;
        return new Buyer(++numberBuyer);
    }

    synchronized static void finalBuyer(){
        processCount--;
        factCount++;
    }

    synchronized static boolean allBuyersInShop(){
        return numberBuyer==planCount;
    }



}
