package by.it.romankov.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer {

    private String name;
    private Map<String, Integer> bascet;

    public Buyer(int number) {
        name = "Покупатель №" + number;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "зашел в торговый зал");
        Util.sleep(Util.random(500, 1000));
        int bSize = Util.random(1, 4);
        bascet = new HashMap <>(bSize);
        for ( int i = 0; i < bSize; i++ ){
            Map.Entry <String, Integer> good = Goods.getRandomGood();
            bascet.put(good.getKey(), good.getValue());
        }
        System.out.println(this + "выбрал товар");
    }

    @Override
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

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Dispatcher.finalBuyer();
    }

    public void printBascet(){
        int itog= 0;
        for (Map.Entry<String, Integer> good : bascet.entrySet()){
            System.out.println(name + " купил товар " + good.getKey() + " стоимостью " + good.getValue()+" рублей.");
            itog= itog+good.getValue() ;
        }
        System.out.println("Сумма чека равна "+ itog + " рублей");
    }

}
