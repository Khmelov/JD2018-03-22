package by.it.pashkevich.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;


public class Buyer extends Thread implements IBuyer,Comparable<Buyer>{

    private String name;
    private Map<String, Integer> bascet;
    private static Semaphore semaphore = new Semaphore(20);

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
        try {
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            goQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void chooseGoods() throws InterruptedException {
        semaphore.acquire();
        System.out.println(this + "зашел в торговый зал");
        System.out.println("Число покупателей в торговом зале: "+(20-semaphore.availablePermits()));


        int bSize = Util.random(1, 4);
        bascet = new HashMap<>(bSize);
        for ( int i = 0; i < bSize; i++ ){
            Map.Entry <String, Integer> good = Goods.getRandomGood();
            bascet.put(good.getKey(), good.getValue());
            Util.sleep(Util.random(0, 20000));
        }
        System.out.println(this + "выбрал товар");
        semaphore.release();
        }

    @Override
    public void goQueue() throws InterruptedException {

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

    @Override
    public int compareTo(Buyer o) {
        return 0;
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
