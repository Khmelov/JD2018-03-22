package by.it.romankov.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, Integer> map = new HashMap <>();
        while (true) {
            String str = scanner.next();
            if (str.equals("end"))
                break;
            if (map.containsKey(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);

        }
        System.out.println(map);
    }


}


