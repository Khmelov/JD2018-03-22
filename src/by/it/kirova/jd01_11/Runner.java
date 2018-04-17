package by.it.kirova.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        System.out.println("\nList A\n");
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        System.out.println("add(T e) in myList: " + myList);

        arList.add("one");
        arList.add("two");
        arList.add("three");
        arList.add("four");
        System.out.println("add(T e) in arList: " + arList);

        myList.remove(0);
        System.out.println("remove(int index = 0) in myList: " + myList);

        arList.remove(0);
        System.out.println("remove(int index = 0) in arList: " + arList);

        System.out.println("get(int index = 1) in myList: " + myList.get(1));
        System.out.println("get(int index = 1) in arList: " + arList.get(1));



        System.out.println("\nListB\n");
        List<String> myListB = new ListB<>();

        myListB.add("one");
        myListB.add("two");
        myListB.add("three");
        myListB.add("four");
        myListB.remove(0);

        System.out.println("set(int index = 2, T e = \"nine\") in myList: " + myListB.set(2, "nine"));
        System.out.println("set(int index = 2, T e = \"nine\") in arList: " + arList.set(2, "nine"));

        myListB.add(1, "ten");
        System.out.println("add(int index = 1, T e = \"ten\") in myList: " + myListB);
        arList.add(1, "ten");
        System.out.println("add(int index = 1, T e = \"ten\") in arList: " + arList);


        myListB.addAll(myListB);
        System.out.println("addAll(Collection<? extends T> array) in myList: " + myListB);
        arList.addAll(arList);
        System.out.println("addAll(Collection<? extends T> array) in arList: " + arList);

        System.out.println("\nSetC\n");
        Set<Integer> mySet = new SetC<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> addedSet = new HashSet<>();
        addedSet.add(45);
        addedSet.add(4);
        addedSet.add(1);
        addedSet.add(10);

        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        System.out.println("add(T e) in mySet: " + mySet);

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println("add(T e) in HashSet: " + set);

        System.out.println("remove(Object o = 5) in mySet: " + mySet.remove(5) + " , mySet: " + mySet);
        System.out.println("remove(Object o = 5) in HashSet: " + set.remove(5) + " , HashSet: " + set);

        System.out.println("contains(Object o = 5) in mySet: " + mySet.contains(5));
        System.out.println("contains(Object o = 5) in HashSet: " + set.contains(5));

        System.out.println("size() mySet: " + mySet.size());
        System.out.println("size() HashSet: " + set.size());

        System.out.println("isEmpty() mySet: " + mySet.isEmpty());
        System.out.println("isEmpty() HashSet: " + set.isEmpty());

        System.out.println("addedSet for addAll, containsAll, removeAll: " + addedSet);
        mySet.addAll(addedSet);
        System.out.println("addAll(Collection<? extends T> array) in mySet: " + mySet);
        set.addAll(addedSet);
        System.out.println("addAll(Collection<? extends T> array) in HashSet: " + set);

        System.out.println("containsAll(Collection<?> c) in mySet: " + mySet.containsAll(addedSet));
        System.out.println("containsAll(Collection<?> c) in HashSet: " + set.containsAll(addedSet));

        System.out.println("removeAll(Collection<?> c) in mySet: " + mySet.removeAll(addedSet) + " mySet: " + mySet);
        System.out.println("removeAll(Collection<?> c) in HashSet: " + set.removeAll(addedSet) + " HashSet: " + set);

    }
}
