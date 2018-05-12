package by.it.sgolovach.jd02_02;

public class DispatcherBuyer extends Thread{

    static int countBuyers=100;

    static int countBuyersInShop=0;

    static int countBuyersGoOut=0;

    @Override
    public void run()  {

        System.out.println("Магазин открылся!!!");

        for (int i = 1; i < 121; i++) {
            Util.sleep(1000);
            if (i == 1 || i == 60 && countBuyersInShop <= 10) {
                int count = Util.random(5, 10);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    Thread buyer=new Thread(new Buyer(countBuyersInShop));
                    buyer.start();
                }
            }
            if (i > 1 && i < 31 && countBuyersInShop <= (i + 10) || i > 60 && i < 91 && countBuyersInShop <= (i + 10)) {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    Thread buyer=new Thread(new Buyer(countBuyersInShop));
                    buyer.start();
                }
            }

            if (i > 30 && i < 61 && countBuyersInShop <= (40 + (30 - i)) || i > 90 && i < 121 && countBuyersInShop <= (40 + (30 - i))) {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    Thread buyer=new Thread(new Buyer(countBuyersInShop));
                    buyer.start();
                }
            }

            if(i==120&&(countBuyers-countBuyersInShop)>0){
                int ras=countBuyers-countBuyersInShop;
                for (int j = 0; j <ras ; j++) {
                    countBuyersInShop++;
                    Thread buyer=new Thread(new Buyer(countBuyersInShop));
                    buyer.start();
                }
            }
        }


    }
}
