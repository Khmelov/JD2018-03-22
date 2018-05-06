package by.it.volchek.jd02_02;

/**
 * Created by volchek on 26.04.18.
 */
public interface IBuyer {
    void enterToMarket();
    void goOut();
    void chooseGoods();
    void goQueue() throws InterruptedException;



}
