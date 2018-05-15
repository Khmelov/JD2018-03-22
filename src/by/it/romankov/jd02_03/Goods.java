package by.it.romankov.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static HashMap<String, Integer> goods = new HashMap<String, Integer>(){{
        put("хлеб", 10);
        put("батон", 24);
        put("молоко", 37);
        put("сосиски", 44);
        put("вода", 5);
        put("соль", 6);
        put("чипсы", 77);
        put("мука", 88);
        put("макароны", 90);
        put("картошка", 10);
    }};


    public static Map.Entry<String, Integer> getRandomGood(){
        int random = by.it.romankov.jd02_02.Util.random(0, goods.size() - 1);
        Map.Entry[] arr = goods.entrySet().toArray(new Map.Entry[1]);
        return arr[random];
    }
}
