package by.it.poprugo.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        List<Integer> list=new ArrayList<>();
        int endPositive=0;
        while (!(str=scanner.next()).equals("end")) {
            Integer element=Integer.valueOf(str);
           if (element>0)
               list.add(endPositive++,element);
           else if (element==0)
               list.add(endPositive,0); //без увеличения "счётчика", т.е. ноль - перед нулём и - дальше идём
           else
               list.add(element); //будет записываться в конец списка (после нулей)
        }
        System.out.println(list);
    }
}
