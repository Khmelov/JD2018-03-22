package by.it.fando.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static HashMap<String, Double> products = new HashMap<>() {
        {
            this.put("хлеб", 1.1);
            this.put("молоко", 2.2);
            this.put("сахар", 3.3);
            this.put("соль", 4.4);
            this.put("масло", 5.5);
        }
    };
    static ArrayList<Map.Entry<String, Double>> pairs = new ArrayList<>(products.entrySet());

}
