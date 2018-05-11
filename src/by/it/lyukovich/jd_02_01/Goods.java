package by.it.lyukovich.jd_02_01;

import java.util.HashMap;

public class Goods {
    HashMap<String, Double> goods = new HashMap<>();

    public Goods() {
        goods.put("хлеб", 2.00);
        goods.put("батон", 3.00);
        goods.put("мясо", 10.25);
        goods.put("конфеты", 7.99);
        goods.put("молоко", 2.00);
        goods.put("яйца", 3.25);
        goods.put("минералка", 1.55);
        goods.put("фасоль", 1.25);
        goods.put("мороженное", 1.35);
    }

    public String takeGood() {
        int randomGood = Util.random(0, goods.size() - 1);
        for (String good : goods.keySet()) {
            if(randomGood == 0)
                return good + "/"+goods.get(good).toString();
            randomGood--;
        }
        return null;
    }

}