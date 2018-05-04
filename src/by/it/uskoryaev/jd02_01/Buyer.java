package by.it.uskoryaev.jd02_01;

public class Buyer extends Thread implements IBuyer {

    private String name;

    public Buyer(int number) {
        name = "Покупатель № "+number;
    }

    @Override
    public String toString() {
        return name+" ";
    }

    @Override
    public void run() {
        super.run();
        enterToMarket();
        chooseGoods();
        goOut();
    }
    @Override
    public void enterToMarket() {
        System.out.println(this+"Покупатель зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"Зашел на ТЗ");
        Util.sleep(Util.random(500,2000));
        System.out.println(this+"выбрал товар");
        QueueBuyer.addBuyer(this);

    }

    @Override
    public void goOut() {
        System.out.println(this+"вышел из ТЗ");
    }
}
