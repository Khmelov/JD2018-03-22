package by.it.poprugo.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();

        System.out.println("TestA \nadd(T e)");
        myList.add("one"); myList.add("two"); myList.add("four");
        arList.add("one"); arList.add("two"); arList.add("four");
        System.out.println("myList:" + myList + "\narList" + arList);

        myList.remove(2); arList.remove(2);
        System.out.println("remove(int ind) [2] \nmyList:" + myList + "\narList" + arList);

        System.out.println("get(int ind) [0] \nmyList(0):"+myList.get(0)+"\narList(0):"+arList.get(0));
        System.out.println("get(int ind) [1] \nmyList(1):" + myList.get(1) + "\narList(1)" + arList.get(1));

        System.out.println("TestB");
        arList.clear();
        List<String> myListB = new ListB<>();
        myListB.add("first"); myListB.add("second"); myListB.add("fourth");
        arList.add("first"); arList.add("second"); arList.add("fourth");
        System.out.println("myListB:" + myListB + "\narList" + arList);myList.add(2, "three"); myList.add(0, "start");

        myListB.add(2, "three"); myListB.add(0, "start");
        arList.add(2, "three"); arList.add(0, "start");
        System.out.println(" add(int ind, T e) [2],[0]\nmyListB:" + myListB + "\narList" + arList);

        myListB.set(3, "third");
        arList.set(3, "third");
        System.out.println(" set(int ind, T e) [3]\nmyListB:" + myListB + "\narList" + arList);

        myListB.addAll(myListB);
        arList.addAll(arList);
        System.out.println(" addAll(Collection<? extends T> T e(array))\nmyListB:" + myListB + "\narList" + arList);
        //addAll НЕ работает(НЕ добавляет myListB, но добавляет arList)!!!

        /*myList.remove("start");
        arList.remove("start");
        System.out.println("remove (T e), remove(int ind) [3] myList:" + myList + "\narList" + arList);*/

        System.out.println("TestC");
        Set<Integer> mySet = new SetC<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> addedSet = new HashSet<>();
        mySet.add(1); mySet.add(2); mySet.add(3); mySet.add(4); mySet.add(5);
        System.out.println("add(T e) in mySet: " + mySet);
        set.add(1); set.add(2); set.add(3); set.add(4); set.add(5);
        System.out.println("add(T e) in HashSet: " + set);
        addedSet.add(45); addedSet.add(4); addedSet.add(1); addedSet.add(10);

        System.out.println("remove(Object o = 5) \nin mySet: " + mySet.remove(5) + " \nin HashSet: " + set.remove(5));
        System.out.println("contains(Object o = 5) \nin mySet: " + mySet.contains(5) + "\nin HashSet: " + set.contains(5));

        System.out.println("size() \nmySet: " + mySet.size() + "\nHashSet: " + set.size());

        System.out.println("isEmpty() \nmySet: " + mySet.isEmpty() + "\nHashSet: " + set.isEmpty());

        System.out.println("addedSet for addAll, containsAll, removeAll: " + addedSet);
        mySet.addAll(addedSet);
        System.out.println("addAll\nin mySet: " + mySet);
        set.addAll(addedSet);
        System.out.println("in HashSet: " + set);

        System.out.println("containsAll\nin mySet: " + mySet.containsAll(addedSet));
        System.out.println("in HashSet: " + set.containsAll(addedSet));

        System.out.println("removeAll\nin mySet: " + mySet.removeAll(addedSet) + " mySet: " + mySet);
        System.out.println("in HashSet: " + set.removeAll(addedSet) + " HashSet: " + set);
    }
}
