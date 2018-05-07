package by.it.volchek.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by volchek on 26.04.18.
 */
public class Buyer extends Thread implements IBuyer,IUseBasket {
    private String name;
    boolean pensioneer=false;
    private Map<String,Double> buyerGoods =new HashMap<>();
    public Buyer (int number){
        name = "Покупатель №"+number;
        if (number%4==0) pensioneer=true;
    }

    @Override
    public String toString() {

        if (pensioneer)return name+"(пенсионер) ";
        else return name +" ";
    }

    @Override
    public void run(){
        long start = System.nanoTime();
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodToBasket();
        goOut();
        long end = System.nanoTime();
        System.out.println(this+"пробыл в магазине --------------------------->"+ (end-start)/1000000+" секунд");
    }
    @Override
    public void enterToMarket() {
        System.out.println(this+"зашел в магазин");

    }

    @Override
    public void goOut() {
        System.out.println(this+"вышел из магазина");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"зашел в торговый зал");
        Util.sleep(random(500,2000));
        System.out.println(this+"выбрал товар");
        QueueBuyer.addBuyer(this);

    }

    @Override
    public void takeBasket() {
        Util.sleep(random(100,200));
        System.out.println(this+"взял корзину");

    }

    @Override
    public void putGoodToBasket() {
        Object goodName;
        for (int i = 0; i < Util.random(1,5) ; i++) {
            Util.sleep(random(100,200));

            goodName = Goods.goodNames.get(Util.random(Goods.goodNames.size()-1));
            System.out.println(this+"положил в корзину "+goodName);
            if (!buyerGoods.containsKey((String)goodName))
            buyerGoods.put((String)goodName,1.0);
            else  buyerGoods.put((String)goodName,buyerGoods.get((String)goodName)+1.0);
        }
        System.out.println(this+"всего выбрал:");
        for (Map.Entry<String, Double> stringDoubleEntry : buyerGoods.entrySet()) {
            System.out.println(stringDoubleEntry.getKey()+" "+stringDoubleEntry.getValue());
        }


    }
    int random (int from, int to){
        if (pensioneer)
        return (int)(1.5*(from+(int)(Math.random()*(to-from+1))));
        else  return from+(int)(Math.random()*(to-from+1));
    }
     int random (int count){
         if (pensioneer)
             return (int)(1.5*(random(0,count)));
             else
        return random(0,count);
    }
}
