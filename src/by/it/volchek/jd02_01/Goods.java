package by.it.volchek.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by volchek on 30.04.18.
 */
public class Goods {
    public static Map<String, Double> goods = new HashMap<String, Double>();
  //  public static  Object[] goodNames;
    static ArrayList<String> goodNames = new ArrayList<>();
    public static void fillStoreWithGoods () {
        goods.put("апельсины", 7.60);
        goods.put("яблоки",6.70);
        goods.put("помидоры",7.80);
        goods.put("ананас",9.90);
        goods.put("сливы", 7.45);
        goods.put("груши",11.30);
        for (Map.Entry<String, Double> stringDoubleEntry : goods.entrySet()) {
            goodNames.add(stringDoubleEntry.getKey());
        }
        //goodNames = goods.keySet().toArray();


    }

}
