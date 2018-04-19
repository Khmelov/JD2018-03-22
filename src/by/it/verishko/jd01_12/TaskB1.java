package by.it.verishko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String str;
        int pos = 0;
        while (!(str = sc.next()).equals("end")) {
            Integer value = Integer.valueOf(str);
            if (value > 0)
                arr.add(pos++, value);
            else if (value > 100) break;
        }
    }
}
