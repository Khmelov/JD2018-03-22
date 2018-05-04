package by.it.verishko.jd02_01;

public class Buyer extends Thread implements IBuyer {

    private String name;

    public Buyer(int number) {
        name = "Покупатель № " + number;
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
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "зашел в торговый зал");
        try {
            sleep((int) (500 + Math.random() * 1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + "выбрал товар");

    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
    }
}
