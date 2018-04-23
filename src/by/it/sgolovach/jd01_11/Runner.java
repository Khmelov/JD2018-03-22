package by.it.sgolovach.jd01_11;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
//        SetC<String> myList = new SetC<>();
//        SetC<String> myList1 = new SetC<>();
//        SetC<String> myList2 = new SetC<>();
//        Set<String> arList = new HashSet<>();
//        Set<String> arList1 = new HashSet<>();
//
//        myList.add("one");
//        myList.add("two");
//        myList.add("three");
//        myList.add("fff");
//        myList.add(null);
//        myList.add(null);
//        myList2.add("one");
//        myList2.add("two");
//        myList2.add("three");
//        myList2.add("fff");
//        myList2.add(null);
//        myList2.add(null);
//        myList1.add("one");
//        myList1.add("dff");
//        myList1.add("dfdf");
//        myList1.add(null);
//        myList.addAll(myList1);
//        System.out.println(myList + " " + myList.size());
//        myList2.addAll(myList1);
//        System.out.println(myList2 + " " + myList2.size());
//
//        arList.add("one");
//        arList.add("two");
//        arList.add("three");
//        arList.add("one");
//        arList.add(null);
//        arList.add(null);
//        arList1.add("one");
//        arList1.add("dff");
//        arList1.add("dfdf");
//        System.out.println(arList1.size());
//        arList.addAll(arList1);
//        arList.size();
//        System.out.println(arList);
//        myList1.add("one1");
//        myList1.add("two2");
//        myList1.add("three3");
//        myList1.add("four4");

        SetC<Short> a = new SetC<>();
        Set<Short> e = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            e.add((short) (i * 2));
            a.add((short) (i * 2));
        }

        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);
        e.addAll(added);
        a.addAll(added);
        System.out.println(e + "\n" + a);
        e.removeAll(added);
        a.removeAll(added);


        System.out.println(e + "\n" + a);
    }
}
