package by.it.shvedov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        String str;
        if(!(str=scan.next()).equals("end")) {
            list.add(str);
        }
        System.out.println(list);
    }
}
