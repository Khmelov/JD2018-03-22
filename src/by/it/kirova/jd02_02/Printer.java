package by.it.kirova.jd02_02;

import java.util.ArrayList;

public class Printer {

    static final Object singlePrinterAccess = new Object();

    public static void printMessage(String message){
        synchronized (singlePrinterAccess){
            System.out.println(message);
        }
    }

    public static double printCheck(ArrayList<String> buyerBacket, String buyerName, String cashierName) {
       synchronized (singlePrinterAccess){
           double totalCost = 0;
           System.out.println("\t*\t\u001B[32m" + cashierName + "\u001B[0m");
           for (String good : buyerBacket) {
               double cost = Goods.goodsAccess.getCost(good);
               System.out.println("\t*\t\u001B[33m" + good + " " + cost + " р.\u001B[0m");
               totalCost += cost;
           }
           //System.out.println("\t*\t\u001B[32m" + buyerName + ", ИТОГО: "+ totalCost + " р.\u001B[0m");
           System.out.print("\t*\t\u001B[32m" + buyerName + ", ИТОГО: ");
           System.out.printf("%.2f", totalCost);
           System.out.println(" р.\u001B[0m");
           return totalCost;
       }
    }

//    public static void printStatistics(ArrayList<Cashier> cashiers, int queueSize){
//        System.out.print("STATISTICS:\t");
//        synchronized (singlePrinterAccess){
//            double total = 0;
//            for (Cashier c: cashiers) {
//                double localCost = c.getTotalCost();
//                total += localCost;
//                System.out.print(localCost + "\t");
//            }
//            System.out.print(queueSize + "\t");
//            System.out.println(total);
//        }
//    }
}
