package by.it.shvedov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListB<>();
        List<String> arList = new ListB<>();
        myList.add("one");
        myList.add("two");
        System.out.println(myList);

        arList.add("one");
        arList.add("two");
        System.out.println(arList);


        myList.remove(0);
        System.out.println(myList);

        arList.remove(0);
        System.out.println(arList);
    }
}
