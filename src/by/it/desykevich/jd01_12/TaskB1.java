package by.it.desykevich.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner (System.in);
        String str;
        Map<String, Integer> map = new HashMap<>();

        while (!(str=sc.next()).equals("end")) {
            str = str.replaceAll("[^A-Za-z']", " ");

            for (String s : str.split(" ")) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        map.remove("");
        System.out.println(map);
    }
}
