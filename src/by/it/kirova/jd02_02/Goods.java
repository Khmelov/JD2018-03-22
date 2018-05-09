package by.it.kirova.jd02_02;


import java.util.HashMap;

public class Goods {
    private HashMap<String, Double> goods = new HashMap<>();

    public static Goods goodsAccess = new Goods();

    private Goods() {
        goods.put("молоко", 2.21);
        goods.put("картофель", 1.22);
        goods.put("колбаса", 14.25);
        goods.put("сыр", 3.89);
        goods.put("хлеб", 2.54);
        goods.put("яйца", 2.95);
        goods.put("сметана", 3.05);
    }

    public String getRandomGood() {
        int randomIndex = Util.random(0, goods.size() - 1);
        for (String good : goods.keySet()) {
            if(randomIndex == 0)
                return good;
            randomIndex--;
        }
        return null;
    }

    public Double getCost(String good) {
        return goods.get(good);
    }
}
