package by.it.pashkevich.jd02_03;

public interface IBuyer {
    void enterToMarket();

    void chooseGoods() throws InterruptedException;

    void goQueue() throws InterruptedException;

    void goOut();
}
