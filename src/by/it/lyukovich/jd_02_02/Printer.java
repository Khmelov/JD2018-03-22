package by.it.lyukovich.jd_02_02;

public class Printer extends Thread {

    public void run() {
        StringBuilder sb = new StringBuilder();
        while (!Dispatcher.endCashiers()) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.delete(0,sb.length());
            int buyers = ShopRunner.countBuyers();
            int inQueue = ShopRunner.countBuyersInQueue();
            int onDuty = ShopRunner.cashiersOnDuty.get();
                sb.append("Покупателей в магазине: " + buyers  + "\n").
                        append("Покупателей в очереди:" + inQueue + "\n").
                        append("Открыто касс: " + onDuty);
                System.out.println(sb);

        }
        System.out.println("Магазин закрылся");
    }
}
