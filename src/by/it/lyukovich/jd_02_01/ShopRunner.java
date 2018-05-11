package by.it.lyukovich.jd_02_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SuppressWarnings("ALL")
public class ShopRunner {
    static int numberBuyer = 0;
    public static final int second=100;
    static ArrayList<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        final int OPENHOURS = 120;
        Goods goods = new Goods();
        List<Integer> buyersCounterList = new ArrayList<Integer>();
        int t =0;
        int buyersInside = 0;
        for (int i = 0; i < OPENHOURS; i++) {
            int count;
            if (i==0) count=Util.random(9,11); else count= Util.random(0, 2);
            Util.sleep(second);
            t++;
            if((buyersInside<=t+10 && t<=30) || (buyersInside<=40+(30-t) && t>30)){
                for (int j = 0; j < count; j++) {
                    buyerStarter(goods);
                }
            }
            buyersInside = countBuyers();
            System.out.println("Покупателей в магазине: " + buyersInside);
            buyersCounterList.add(buyersInside);
            if (t==60) t =0;
        }
        while (countBuyers() > 0) {
            Util.sleep(100);
        }
        String maxBuyersTime="";
        int maxBuyers = Collections.max(buyersCounterList);
        for (int i = 0; i < buyersCounterList.size(); i++) {
            if (buyersCounterList.get(i).equals(maxBuyers))
                maxBuyersTime+=i + ",";
        }
        maxBuyersTime=maxBuyersTime.substring(0,maxBuyersTime.length()-1);
        System.out.printf("\nМаксимальное количество людей в магазине было %d на %s секунде\n", maxBuyers, maxBuyersTime);
        System.out.println("time count\n");
        //Проверка количества по времени
        /*for (int i = 0; i < buyersCounterList.size(); i++) {
            System.out.printf("%-4d %-4d\n", i, buyersCounterList.get(i));
        }*/
    }

    public static void buyerStarter(Goods g){
        Buyer buyer = new Buyer(++numberBuyer, g);
        buyers.add(buyer);
        buyer.start();
    }

    public static int countBuyers() {
        int count = 0;
        for (Buyer buyer : buyers) {
            if (buyer.getState() != Thread.State.TERMINATED)
                count++;
        }
        return count;

    }
}
