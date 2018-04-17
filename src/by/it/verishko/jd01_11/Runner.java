package by.it.verishko.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ListA<>();
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

        Set<String> mySet = new SetC<>();
        mySet.add("one");
        mySet.add("two");
        System.out.println(mySet);

        ArrayList<String> myArrList = new ArrayList<>();
        myArrList.add(null);
        myArrList.add("one");
        myArrList.add("two");
        System.out.println(myArrList.size());
    }
}
