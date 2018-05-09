package by.it.fando.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    HashMap<String, Double> products = new HashMap<>(); {
        products.put("Хлеб",1.1);
        products.put("Молоко",2.2);
        products.put("Сахар",3.3);
        products.put("Соль",4.4);
        products.put("Масло",5.5);
    }
    Map.Entry[] array = products.entrySet().toArray(new Map.Entry[0]);

}
