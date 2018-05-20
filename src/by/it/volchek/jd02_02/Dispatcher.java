package by.it.volchek.jd02_02;

/**
 * Created by volchek on 05.05.18.
 */
public class Dispatcher {
    final static int planCount =100;
    private static int processCount = 0;
    private static int factCount = 0;
    private static int numberBuyer =0;

    synchronized static boolean planComplete(){
        return factCount >= planCount;
    }

   synchronized static Buyer addNewBuyer(){
        processCount++;
       return new Buyer(++numberBuyer);

    }

   synchronized static  void finalBuyer(){
        factCount++;
        processCount--;
    }
    static boolean allBuyersInShop(){
        return numberBuyer==planCount;
    }
}
