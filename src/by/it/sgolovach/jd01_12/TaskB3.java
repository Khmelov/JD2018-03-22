package by.it.sgolovach.jd01_12;

import java.util.*;

public class TaskB3 {

    static String process(ArrayList<String> peoples) {
        int i = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2 > 0) iterator.remove();
                i++;
            }
        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        for (int i = 1; i <= 4096; i++) {
            list.add("Name" + i);
            linkedList.add("Name" + i);
        }

        long t = System.nanoTime();
        System.out.println(process((ArrayList<String>) list));
        long arrayTime = System.nanoTime() - t;
        System.out.println(arrayTime / 1000);
        t = System.nanoTime();
        System.out.println(process((LinkedList<String>) linkedList));
        long linkedTime = System.nanoTime() - t;
        System.out.println(linkedTime / 1000);


    }
}
