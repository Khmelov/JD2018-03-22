package by.it.lyukovich.jd_02_03;

public class Printer extends Thread {

    public void run() {
        StringBuilder sb = new StringBuilder();
        while (!Dispatcher.endCashiers()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.delete(0,sb.length());
            int buyers = ShopRunner.countBuyers();
            int inHallQueue = 20 - Buyer.enterLimit.availablePermits();
            int inQueue = ShopRunner.countBuyersInQueue();
            int onDuty = ShopRunner.cashiersOnDuty.get();
                sb.append("Покупателей в магазине: " + buyers  + "\n").
                        append("Очередь на вход в торговый зал:" + inHallQueue + "\n").
                        append("Покупателей в очереди кассу: " + inQueue + "\n").append("Открыто касс: " + onDuty);;
                System.out.println(sb);

        }
        System.out.println("Магазин закрылся");
    }
}
