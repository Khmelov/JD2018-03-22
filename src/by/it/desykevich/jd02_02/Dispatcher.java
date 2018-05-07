package by.it.desykevich.jd02_02;

public class Dispatcher {

    private static int countBuyer = 0;
    private final static int planCount=100;
    private static int processCount=0;
    private static int factCount=0;

      synchronized static boolean planComplete (){
         return factCount>=planCount;
    }

      synchronized static Buyer addnewBuyer (){
        processCount++;
        return new Buyer(++countBuyer);
     }


      synchronized static void finalBuyer (){
        processCount--;
        factCount++;
     }

}
