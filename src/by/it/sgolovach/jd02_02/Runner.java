package by.it.sgolovach.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner{

    static List<String> goodCatalague = new ArrayList<>();
    static Map<String, Integer> goods = new HashMap<>();

    public static void main(String[] args) {

        goodCatalague.add("хлеб");goodCatalague.add("вода");goodCatalague.add("молоко");goodCatalague.add("колбаса");
        goodCatalague.add("консервы");goodCatalague.add("булочка");goodCatalague.add("мясо");goodCatalague.add("йогурт");
        goodCatalague.add("шоколад");goodCatalague.add("макароны");

        goods.put("хлеб", 5);goods.put("вода", 10);goods.put("молоко", 6);goods.put("колбаса", 20);
        goods.put("консервы", 15);goods.put("булочка", 2);goods.put("мясо", 25);goods.put("йогурт", 4);
        goods.put("шоколад", 7);goods.put("макароны", 12);

        Thread dispBuyer = new Thread(new DispatcherBuyer());
        dispBuyer.start();

    }
}
