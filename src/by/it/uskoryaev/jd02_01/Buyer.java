package by.it.uskoryaev.jd02_01;

public class Buyer extends Thread implements IBuyer {

    private String name;

    Buyer(int number) {
        name = "Покупатель №" + number;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"зашел на торговый зал");
        Util.sleep(Util.random(500,2000));
        System.out.println(this+"выбрал товар");
        QueueBuyer.addBuyer(this);


    }

    @Override
    public void goOut() {
        System.out.println(this+"вышел из магазина");
    }
}