package by.it.danilevich.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, Comparable<Buyer> {
    private double koefSpeed;
    private String name;
    private double totalMoney;
    private int number =0;
    private ArrayList<ArrayList<String>> selectProduct;

    @Override
    public int compareTo(Buyer o) {
        return 0;
    }

    public int getNumber() {
        return this.number;
    }

    public Buyer(int number, Boolean pens) {
        if (!pens) {
            this.name = "Покупатель №" + number;
            this.koefSpeed = 1.15;
            this.number = number;
        } else {
            this.name = "Покупатель-пенсионер №" + number;
            this.koefSpeed = 1;
            this.number = number;
        }
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    String getNameBuyer(){
        return this.name;
    }
    @Override
    public String toString() {
        return this.name + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goQueue();
        goOut();
        if (getNumber()%10==0){
            printInfoShop();
        }
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "зашел в торговый зал");
        try {
            Dispatcher.canChooseGoods.acquire();
            Dispatcher.countChooseGoods++;
            System.out.println("Выбирает товар "+Dispatcher.countChooseGoods + " чел.");
            Backet backet = new Backet(this);
            Util.sleep(Util.random(1000,2000));
            backet.takeBacket();
            Util.sleep(Util.random(1000,2000));
            selectProduct = backet.putGoodsToBacket();
            this.totalMoney = countMoney();
            int timeForSelect = Util.random((int) (500*this.koefSpeed),(int) (2000*this.koefSpeed));//в миллисекундах
            Util.sleep(timeForSelect);
            System.out.println(this.name + " выбрал товар за " + (double)timeForSelect/1000+" сек.");
            Dispatcher.canChooseGoods.release();
            Dispatcher.countChooseGoods--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private double countMoney(){
        double sum =0;
        for (ArrayList<String> tov: selectProduct ) {
            sum = sum+ Double.valueOf(tov.get(1));
        }
        return sum;
    }
    @Override
    public void goQueue() {
        System.out.println(this + "встал в очередь");
        QueueBuyer.addBuyer(this);
        while (QueueBuyer.buyerInQueue(this))
            //синхронизация происходит по this (текущий покупатель)
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Dispatcher.finalBuyer();
    }

    private void printInfoShop(){
        ArrayList<Cashier> cashierArrayList= Dispatcher.getCashierArrays();
        for (Cashier cashier: cashierArrayList){
            System.out.print(String.format("%40s", cashier.toString()));
        }
        System.out.print(String.format("%40s", "Очередь"));
        System.out.print(String.format("%40s", "Выручка магазина"));
        System.out.println();
        double sum = 0;
        for (Cashier cashier: cashierArrayList){
            sum = sum + cashier.getTotalMoney();
            System.out.print(String.format("%40s", "Обслужено: "+
                    cashier.getCountServiceByuer()+" чел., выручка: ") +
                    String.format("%.2f",cashier.getTotalMoney()));
        }
        System.out.print(String.format("%40s",QueueBuyer.getSizeQueue()));
        System.out.print(String.format("%40s",sum));
    }
}
