package by.it.kirova.jd02_02;

import java.util.ArrayList;

public class Printer {

    static boolean printAll = false;
    static final Object singlePrinterAccess = new Object();
    static double total = 0;

    public static void printMessage(String message) {
        if (!printAll)
            return;
        synchronized (singlePrinterAccess) {
            System.out.println(message);
        }
    }

    public static double printCheck(ArrayList<String> buyerBacket, String buyerName, int number) {
        String spaces = (number == 0) ? "" : String.format("%" + number * 20 + "s", " ");
        synchronized (singlePrinterAccess) {
            double totalCost = 0;
            //System.out.println("\t*\t\u001B[32m" + cashierName + "\u001B[0m");
            System.out.println(spaces + "\u001B[32m" + buyerName + ":\u001B[0m");
            for (String good : buyerBacket) {
                double cost = Goods.goodsAccess.getCost(good);
                System.out.println(spaces + good + " " + cost + " р.");
                totalCost += cost;
                total += totalCost;
            }
            //System.out.println("\t*\t\u001B[32m" + buyerName + ", ИТОГО: "+ totalCost + " р.\u001B[0m");
            System.out.print(spaces + "\u001B[32mИТОГО: ");
            System.out.printf("%.2f", totalCost);
            System.out.println(" р.\u001B[0m");
            String cntStr =  QueueBuyer.getSize() + " человек";
            System.out.print(String.format("%" + 100 + "s", " ") + cntStr);
            System.out.print(String.format("%" + (20-cntStr.length()) + "s", " "));
            System.out.print("\u001B[32m");
            System.out.printf("%.2f", total);
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
