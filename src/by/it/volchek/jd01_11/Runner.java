package by.it.volchek.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by volchek on 14.04.18.
 */
public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();
        List<String> myList2 = new ListB<>();
        myList.add("one");
        myList.add("two");
        System.out.println(myList);

        myList2.add("one");
        myList2.add("two");
        System.out.println(myList2);


        arList.add("one[ar]");
        arList.add("two");
        System.out.println(arList);

        myList2.add(5, "three");
        myList2.add(1, "four");

        System.out.println(myList2);
        System.out.println("_________");

       // myList2.set(5, "three");
        myList2.set(1, null);
        myList2.set(4, "eight");
        myList2.set(5, "eight");


        System.out.println(myList2);
        System.out.println("добавление всего листа arList");
        myList2.addAll(arList);

        System.out.println(myList2);

        System.out.println("__________");
        System.out.println("добавление всего листа myList");
  //      myList2.addAll(myList);

        System.out.println(myList2);

        System.out.println("__________");


        Set<String > mySet = new SetC<>();
        mySet.add("one");
        mySet.add("two");
        mySet.add("three");
        mySet.add("three");
        mySet.add("three");
        mySet.add("two");

       mySet.add("four");
        mySet.add("four");
        mySet.add("five");
        mySet.add("one");
        mySet.remove("five");
        System.out.println(mySet);
        System.out.println(mySet.contains("four"));
        System.out.println(mySet.contains("one"));
        System.out.println(mySet.contains("five"));
        System.out.println(mySet.contains("i"));
        System.out.println(mySet.contains(""));
        System.out.println(mySet.contains(null));
        System.out.println(mySet.size());
        System.out.println(mySet.isEmpty());


        System.out.println("Добавление arList'a");
        mySet.addAll(arList);
        System.out.println(mySet);

        System.out.println(mySet.containsAll(arList));
        arList.add("five");
        System.out.println(mySet.containsAll(arList));

       System.out.println("-------------------------");
        System.out.println(mySet);
        System.out.println(arList);
        mySet.removeAll(arList);
        System.out.println(mySet);
        myList2.add("___________");
        System.out.println(" ++++" + myList2);
        System.out.println(mySet);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add(null);
        list2.add(null);
        list2.add("one");
        list2.add("one");
        list2.add("othree");
       // mySet.addAll(list2);
        mySet.add(null);
        mySet.add(null);
        mySet.add(null);
        mySet.add("seven");
        System.out.println(mySet);










    }
}
