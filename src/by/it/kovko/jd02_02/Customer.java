package by.it.kovko.jd02_02;

import java.util.HashMap;

public interface Customer extends Comparable<Customer>{
    public void setPriority(int priority);
    public int getPriority();
    String getName();
    public long getQueueingTime();
    public void setQueueingTime();
    HashMap<Shop.Goods, Integer> getShoppingList();
    void enter();
    void exit();
    void takeCart();
    void choose();
    void putIntoCart();
    void standInLine();
}
