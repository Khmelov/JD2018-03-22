package by.it.fando.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(Integer.toString(i));
        }

        Timer t = new Timer();
        ArrayList<String> array = new ArrayList<>(list);
        System.out.println("В ArrayList: "+process(array)+"\n"+t);
        LinkedList<String> linked = new LinkedList<>(list);
        System.out.println("В LinkedList: "+process(linked)+"\n"+t);
    }

    private static String process(ArrayList<String> peoples) {
        int lost = 0;
        int k=2;
        while (peoples.size() > 1) {
            lost = (lost + k - 1) % peoples.size();
            peoples.remove(lost);
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

}
