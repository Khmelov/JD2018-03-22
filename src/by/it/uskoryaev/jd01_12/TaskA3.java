package by.it.uskoryaev.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        int positive = 0;
        List<Integer> list = new ArrayList<>();
        while (!(str = scanner.next()).equals("end")){
            Integer element = Integer.valueOf(str);
            if (element > 0)
                list.add(positive++,element);
            else if (element == 0 )
                list.add(positive,0);
            else
                list.add(element);
        }
        System.out.println(list);
    }
}
