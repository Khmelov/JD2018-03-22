package by.it.poprugo.jd02_03;

public class Buyer extends Thread implements IBuyer, Comparable<Buyer> {

    private String name;

    @Override
    public int compareTo(Buyer o) {
        return 0;
    }

    public Buyer(int num) {
        name = "Покупатель № " + num + " ";
        start();
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
        System.out.println(">>>" + this + "Зашёл в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "зашёл в торговый зал");
        /*try { - это 2я реализация
            //sleep(1000); - это был 1й вариант
            sleep((int)(500+Math.random()*1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Util.sleep(Util.random(500, 1000)); // - это (3) с использованием class Util
        System.out.println(this + "Выбрал товар" + " vvv");
        //QueueBuyer.addBuyer(this); теперь это происходит в goQueue()
    }

    @Override
    public void goQueue() {
        System.out.println("_____" + this + "встал в очередь" + "_____");
        QueueBuyer.addBuyer(this);
        //синхронизация происходит по this (текущий покупатель)
        while (QueueBuyer.buyerInQueue(this)) //  пока я в очереди я жду пока кассир не извлечёт меня из очереди
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
        Dispatcher.finalBuyer();
        System.out.println(this + "Вышел из магазина" + " >>>");
    }

}
