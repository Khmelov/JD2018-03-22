package by.it.danilevich.jd01_12;

//import java.lang.reflect.Array;
//import java.util.Arrays;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String worlds;
        HashMap<String,Integer> readWorld = new HashMap<>();
     //   Arrays arr = new Arrays();
        while (!(worlds = sc.nextLine()).equals("end")){
              System.out.println(worlds);
              String[] world = worlds.split("[\\s,.:;!?\"—)(]+");
              for (String el:world) {
                  if (!el.isEmpty()) {
                      if (readWorld.containsKey(el)) readWorld.put(el, readWorld.get(el) + 1);
                      else readWorld.put(el, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : readWorld.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println();

    }

}
