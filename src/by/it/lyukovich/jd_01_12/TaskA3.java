package by.it.lyukovich.jd_01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        List<Integer> list = new ArrayList<>();
        int splitter=0;
        while(!(str = scanner.next()).equalsIgnoreCase("end")){
            Integer number = Integer.valueOf(str);
            if (number>0)
                list.add(splitter++,number);
            else if (number==0)
                list.add(splitter,number);
            else
                list.add(number);
        }
        System.out.println(list);
    }
}
