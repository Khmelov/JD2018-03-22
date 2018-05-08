package by.it.kirova.jd02_02;

import java.util.ArrayList;

class Dispatcher {

    static int speed = 1; //во сколько раз ускорить приложение
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
        return new Buyer(++numberBuyer, Goods.goodsAccess);

    }

    static ArrayList<Integer> chart = new ArrayList<>();
    synchronized static boolean needNext(int i){
        int t = i % 60;
        boolean todo = t < 30 ? processCount < (t + 10) : processCount <= 40 + (30 - t);
        if(!todo){
            Printer.printMessage("\nИтерация " + i + "\n");
            Printer.printMessage("Покупателей в магазине: " + processCount);
            chart.add(processCount);
        }
        return todo;
    }

    //синхронизация происходит по объекту Dispatcher.class
    synchronized static void finalBuyer() {
        processCount--;
        factCount++;
        if(processCount == 0){
            for (Cashier c: QueueBuyer.cashiers) {
                synchronized (c){
                    c.notify();
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("График количества покупателей в магазине на каждой итерации:\n");
            sb.append("Time\tAmount\n");
            int second = 0;
            for (Integer c: chart) {
                sb.append((second++) + "\t\t" + c + "\n");
            }
            Printer.printMessage(sb.toString());
        }
    }

    //синхронизация происходит по объекту Dispatcher.class
    synchronized static boolean allBuyersInShop() {
        return numberBuyer == planCount;
    }


}
