package by.it.akhmelev.jd02_03;

public class Buyer extends Thread implements IBuyer, Comparable<Buyer> {

    private String name;

    @Override
    public int compareTo(Buyer o) {
        return 0;
    }

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
        System.out.println(this + "выбрал товар");
        //QueueBuyer.addBuyer(this); теперь это происходит в goQueue()
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

}
