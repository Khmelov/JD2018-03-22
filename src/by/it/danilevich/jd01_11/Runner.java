package by.it.danilevich.jd01_11;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> arList = new ArrayList<>();
        List<String> myList = new ListB<>();
        List<String> myList2 = new ListB<>();
        List<String> arList2 = new ArrayList<>();
        Set<Short> arSet = new HashSet<>();
        Set<Short> mySet = new SetC<>();
        Set<Short> mySet2 = new SetC<>();


        arSet.add((short) 20);
        arSet.add((short) 25);
        arSet.add((short) 10);


        mySet.add((short) 20);
        mySet.add((short) 25);
        mySet.add((short) 10);

        mySet2.add((short) 40);
        mySet2.add((short) 45);
        mySet2.add((short) 70);

        System.out.println(arSet+"\n"+mySet);
        System.out.println(mySet + " contains 15 =" + mySet.contains((short) 15));
        //mySet.addAll(mySet2);
        System.out.println(mySet + " size =" + mySet.size());
        myList2.add("Good");
        myList2.add("Morning");
        myList2.add("Country");
        arList2.add("Good");
        arList2.add("Morning");
        arList2.add("Country");
        //add
        myList.add("First");
        arList.add("First");

        myList.add("Two");
        arList.add("Two");

        myList.add("Three");
        arList.add("Three");

        System.out.println(myList + "\n" + arList);
        myList.add(0,"0");
        arList.add(0,"0");
        System.out.println(myList + "\n" + arList);
        myList.remove("Three");
        arList.remove("Three");

        System.out.println(myList + "\n" + arList);

        myList.remove(1);
        arList.remove(1);
        System.out.println(myList + "\n" + arList);

        arList.set(0,"First");
        myList.set(0,"First");


        System.out.println(myList + "\n" + arList);
        ///////
        arList.addAll(arList2);
        myList.addAll(myList2);
        System.out.println(myList + "\n" + arList);









    }
}

