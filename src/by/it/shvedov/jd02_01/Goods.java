package by.it.shvedov.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Goods {
    public static Map<String,Integer> goods=new HashMap<>();
    static ArrayList<String> name= new ArrayList<>();
    public static  void shopGoods(){
        goods.put("water", 1);
        goods.put("orange", 4);
        goods.put("meat", 8);
        goods.put("pizza",  10);
        for(Map.Entry<String, Integer> i: goods.entrySet()){
            name.add(i.getKey());
        }

    }
}
