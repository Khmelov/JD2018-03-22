package by.it.lyukovich.jd_02_03;

import java.util.*;
import java.util.concurrent.Semaphore;

@SuppressWarnings("Duplicates")
public class Buyer extends Thread implements IBuyer {
    public static List<Thread> buyers = new ArrayList<>();
    public static Semaphore enterLimit = new Semaphore(20);
    int opt1 = 100, opt2 = 200; //Operation time
    private String name;
    private HashMap<String, Double> buylist;
    boolean pensioner;
    Goods goods = new Goods();
    public Buyer(int number, Goods goods) {
        name = "Покупатель №" + number;
        this.goods = goods;
        pensioner = Util.random(1,4) == 4;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        goQueue();
        System.out.println(totalBought());
        goOut();
    }
    private double setSpeed() { //Modify speed for pens
        if (pensioner) return Util.random(1,3)/2.0;
        else return 1;
    }
    @Override
    public void enterToMarket() {
        Util.randomSleep(opt1,opt2,setSpeed());
        System.out.println(name + " зашел в магазин");

    }
    @Override
    public void takeBucket() {
        Util.randomSleep(opt1, opt2, setSpeed());
        buylist = new HashMap<>();
        System.out.println(name + " взял корзину");
    }
    @Override
    public void chooseGoods() {
        try {
            System.out.println(this + "ожидает разрешение зайти в зал.");
            enterLimit.acquire();
            System.out.println(this + "зашел в торговый зал.");
            int goodsCount = Util.random(1, 4);
            for (int i = 0; i < goodsCount; i++) {
                Util.randomSleep(opt1 * 15, opt2 * 30, setSpeed());
                String good = goods.takeGood();
                putGoodsToBucket(good);
            }
            Util.randomSleep(opt1, opt2, setSpeed());
        } catch (InterruptedException e){

        }finally {
            enterLimit.release();
        }
    }
    public String totalBought(){
        StringBuilder sb= new StringBuilder();
        double cashCount=0;
        HashMap<String, Double> bl = new HashMap(buylist);
        Iterator it = bl.entrySet().iterator();
        String goods="";
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            cashCount+=Double.parseDouble(pair.getValue().toString());
        }
        sb.append(this + "купил " + buylist.size() + " товар(а) на сумму " + cashCount);
        return sb.toString();
    }

    @Override
    public void putGoodsToBucket(String good) {
        Util.randomSleep(opt1, opt2, setSpeed());
        String g = good.substring(0,good.indexOf("/"));
        Double p = Double.parseDouble(good.substring(good.indexOf("/")+1));
        buylist.put(g, p);
        System.out.println(name + " положил в корзину " + g + " стоимостью " + p +" в корзину");

    }
    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Dispatcher.finalBuyer();
    }

    public void goQueue() {
        System.out.println(this + "встал в очередь");
        QueueBuyer.addBuyer(this);
        synchronized (this) {
            while (QueueBuyer.buyerInQueue(this))
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

}
