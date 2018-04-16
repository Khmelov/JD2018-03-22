package by.it.sgolovach.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        SetC<String> myList = new SetC<>();
        List<String> myList1 = new ListB<>();
        Set<String> arList = new HashSet<>();
        Set<String> arList1 = new HashSet<>();

        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("fff");
        myList.add(null);
        myList.add(null);
        System.out.println(myList.size());
        myList1.add("one");
        myList1.add("dff");
        myList1.add("dfdf");
        myList1.add(null);
        System.out.println(myList1.size());
        myList.addAll(myList1);
        System.out.println(myList);

        arList.add("one");
        arList.add("two");
        arList.add("three");
        arList.add("one");
        arList.add(null);
        arList.add(null);
        System.out.println(arList.size());
        arList1.add("one");
        arList1.add("dff");
        arList1.add("dfdf");
        System.out.println(arList1.size());
        arList.addAll(arList1);
        arList.size();
        System.out.println(arList);
//        myList1.add("one1");
//        myList1.add("two2");
//        myList1.add("three3");
//        myList1.add("four4");

    }
}
