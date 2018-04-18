package by.it.sgolovach.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String str;
        List<Integer> list = new ArrayList<>();
        int endPositive = 0;
        while (!(str = scaner.next()).equals("end")) {
            Integer element = Integer.valueOf(str);
            if (element > 0)
                list.add(endPositive++, element);
            else if (element == 0)
                list.add(endPositive, 0);
            else
                list.add(element);
        }
        System.out.println(list);
    }
}
