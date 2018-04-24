package by.it.poprugo.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();

        myList.add("one"); myList.add("two"); myList.add("four");
        arList.add("one"); arList.add("two"); arList.add("four");
//        System.out.println(arList);
        System.out.println("myList:" + myList + "\narList" + arList);

        myList.add(2, "three");
        myList.add(0, "start");

        arList.add(2, "three");
        arList.add(0, "start");

        System.out.println("myList:" + myList + "\narList" + arList);

        myList.remove("start");
        myList.remove(3);

        arList.remove("start");
        arList.remove(3);

        System.out.println("myList:" + myList + "\narList" + arList);

        System.out.println("myList(0):"+myList.get(0)+"\narList(0):"+arList.get(0));

        System.out.println();
        arList.clear();
        List<String> myLisB = new ListB<>();

        myLisB.add("first"); myLisB.add("second"); myLisB.add("fourth");
        arList.add("first"); arList.add("second"); arList.add("fourth");

        System.out.println("myLisB:" + myLisB + "\narList" + arList);

//        myList.add(2, "three");
//        myList.add(0, "start");
//
//        arList.add(2, "three");
//        arList.add(0, "start");
//
//        System.out.println("myList:" + myList + "\narList" + arList);
//
//        myList.remove("start");
//        myList.remove(3);
//
//        arList.remove("start");
//        arList.remove(3);
//
//        System.out.println("myList:" + myList + "\narList" + arList);
//
//        System.out.println("myList(0):"+myList.get(0)+"\narList(0):"+arList.get(0));

    }
}
