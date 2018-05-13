package by.it.danilevich.jd02_02;

import java.util.*;

class Dispatcher {
    private static final  int planCount = 5;//максимум что может зайти в магазин
    private static int processCount = 0;//
    private static int factCount = 0;//количество покупателей, которые все совершили и вышли из магазина
    private static int countKass =2;
    private static int maxByerInCashier = 3;
    private static int numberBuyer=0;
    private static int MaxProductInBacket = 4;
    static HashMap<Cashier,String> cashiers = new HashMap<>();
    static HashMap<Buyer,Cashier> buyerKass = new HashMap<>();
    static HashMap<Cashier,Thread> cashiersThread = new HashMap<>();
    static QueueBuyer buyersInKass = new QueueBuyer("Касс");
    static QueueBuyer buyersInQueuq = new QueueBuyer("Общая");

    static int getMaxProductInBacket() {
        return MaxProductInBacket;
    }

    static int getCountKass() {
        return countKass;
    }

    static boolean planComplete(){
        return planCount == factCount;
    }
    /*
    private static int getFactProcess(){
        return processCount;
    }*/
    private static Buyer addNewBuyer(int numberBuyer, boolean pens){
        processCount++;
        Buyer buyer = new Buyer(numberBuyer,pens);
        buyerKass.put(buyer,null);
        return buyer;
    }
    static void finallBuer(){
        factCount++;
        processCount--;
    }

   /* static int getAmountOpenKass(){
        int c =0;
        for (Map.Entry<Cashier, String> s:cashiers.entrySet()) {
           if (s.getValue().equals("open")) c++;
        }
        return c;
    }
*/
    static void openKass(Cashier cashier){
        cashiers.put(cashier, "open");
      }

    //static void closeKass(Cashier cashier){
    //    cashiers.put(cashier, "close");
    //  }

    static int getMaxByerInCashier(){
        return maxByerInCashier;
    }

    static void createKass(){
        for (int i =1; i<=countKass; i++){
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            cashiersThread.put(cashier,thread);
            cashiers.put(cashier,"close");
            System.out.println("Создали кассу " + i);
            thread.start();
        }
    }

    static void createBuer(){
        //while (numberBuyer<=planCount){
        for (int i=0;i<planCount;i++){
            //Util.sleep(1000);
            //int countBuyer = Util.random(1,3);
            int countBuyer=1;
            System.out.println("Сейчас зайдет " + countBuyer + " новых покупателей");
            for (int j = 0; j < countBuyer; j++) {
                Boolean pens =false;
                double k = ((double)(numberBuyer+1))%4;
                if (k==0.0){
                    pens = true;
                }
                numberBuyer++;
                Buyer buyer = Dispatcher.addNewBuyer(numberBuyer,pens);
               // System.out.println("Всего покупателей после прихода " + Dispatcher.getFactProcess());
                buyer.start();
            }
        }
    }


    /*static void BlockForEnter(Cashier cashier) {
        cashiers.put(cashier, "block");
    }*/



}
