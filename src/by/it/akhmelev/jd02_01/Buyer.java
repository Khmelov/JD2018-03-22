package by.it.akhmelev.jd02_01;

public class Buyer extends Thread implements IBuyer {

    private String name;

    public Buyer(int number) {
        name = "Покупатель №" + number;
    }

    @Override
    public String toString() {
        return name+" ";
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();

        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"зашел в торговый зал");
        Util.sleep(Util.random(500,2000));
        System.out.println(this+"выбрал товар");
        QueueBuyer.addBuyer(this);
    }

    @Override
    public void goOut() {
        System.out.println(this+"вышел из магазина");
    }

}
