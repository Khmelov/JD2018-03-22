package by.it.romankov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String str;
        List<Integer> list = new ArrayList <>();
        int endElement=0;
        while (!(str=scanner.next()).equals("end")){
            Integer element = Integer.valueOf(str);
            if(element>0)
                list.add(endElement++, element);
            if(element==0)
                list.add(endElement, element);
            if(element<0)
                list.add(element);


        }

            System.out.println(list);

    }

}
