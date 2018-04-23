package by.it.sgolovach.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    static String process(ArrayList<String> peoples) {
        int i = 0;
        List<String> list = new ArrayList<>(peoples);
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2 > 0) iterator.remove();
                i++;
            }
        }
        String str = list.get(0);
        return str;
    }


    static String process(LinkedList<String> peoples) {
        int i = 0;
        LinkedList<String> list = new LinkedList<>(peoples);
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2 > 0) iterator.remove();
                i++;
            }
        }
        String str = list.get(0);
        return str;
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        list.add("Petrov");
        list.add("Sidorov");
        list.add("Ivanov");
        list.add("Perviy");
        list.add("Vtoroy");
        list.add("Shestoy");
        list.add("Sedmoy");
        list.add("Petrov1");
        list.add("Ivanov1");
        list.add("Sidorov1");
        list.add("Odin");
        System.out.println(process((ArrayList<String>) list));

        linkedList.add("Petrov");
        linkedList.add("Sidorov");
        linkedList.add("Ivanov");
        linkedList.add("Perviy");
        linkedList.add("Vtoroy");
        linkedList.add("Shestoy");
        linkedList.add("Sedmoy");
        linkedList.add("Petrov1");
        linkedList.add("Ivanov1");
        linkedList.add("Sidorov1");
        linkedList.add("Odin");

        System.out.println(process((LinkedList<String>) linkedList));


    }
}
