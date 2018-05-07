package by.it.kirova.jd01_12;

import java.util.*;


public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1
        String str;
        HashMap<Integer, String> map = new HashMap<>();
        while (!(str = scanner.nextLine()).startsWith("end")) {
            int id;
            do {
                id = (int) (Math.random() * 5000 + 1);
            }
            while (map.containsKey(id));
            map.put(id, str);
        }

        //2
        printSortMap(map);

        //3
        HashMap<String, Integer> temp = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            temp.put(entry.getValue(), entry.getKey());
        }
        HashMap<Integer, String> uniqueMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            uniqueMap.put(entry.getValue(), entry.getKey());
        }

        printSortMap(uniqueMap);

    }

//    private static void printMap(HashMap<?, ?> map) {
//        System.out.println();
//        for (Map.Entry<?, ?> entry : map.entrySet()) {
//            System.out.println(entry);
//        }
//    }


    private static void printSortMap(HashMap<Integer, String> map) {
        SortedSet<Integer> sortedKeys = new TreeSet<>(map.keySet());
        System.out.println();
        for (Integer key : sortedKeys) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }

    }
}


