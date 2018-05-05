package by.it.poprugo.jd02_01;

public class Buyer extends Thread implements IBuyer {

    int num;

    public Buyer(int num) {
        this.num = num;
        this.setName("Покупатель № "+ num + " ");
        start();
    }
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run () {
        enterToMarket ();
        chooseGoods ();
        goOut();
    }

    @Override
    public void enterToMarket () { System.out.println(this + "Зашёл в магазин"); }

    @Override
    public void chooseGoods () {
        System.out.println("Зашёл в торговый зал");
        /*try { - это 2я реализация
            //sleep(1000); - это был 1й вариант
            sleep((int)(500+Math.random()*1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Util.sleep(Util.random(500,2000)); // - это (3) с использованием class Util
        System.out.println("Выбрал товар");
        QueueBuyer.addBuyer(this); // встал в очередь
    }

    @Override
    public void goOut() {
        System.out.println(this + "Вышел из магазина");
    }
}
