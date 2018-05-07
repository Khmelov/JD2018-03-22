package by.it.desykevich.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods extends HashMap<String, Double> {

    static {

    }

    private static Goods goods = new Goods() {
        {
            this.put("Хлеб", 1.0);
            this.put("Сметана", 1.5);
            this.put("Соль", 0.8);
            this.put("Молоко", 2.0);
        }
    };

    private Goods() {

    }

    static Double getPrice(String name) {
        return goods.get(name);
    }

    static String rndGoodName() {
        List<String> names = new ArrayList<>(goods.keySet());
        return names.get(Util.random(names.size()));
    }
}
