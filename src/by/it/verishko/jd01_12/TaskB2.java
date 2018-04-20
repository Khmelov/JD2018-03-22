package by.it.verishko.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Пер", "Втор", "Трет", "Четв", "Пят", "Шест", "Седм", "Вос");
        ArrayList<String> arrayList = new ArrayList<>(list);
        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.println("arrayList: " + process(arrayList));
        System.out.println("linkedList: " + process(linkedList));
    }

    static String process(ArrayList<String> peoples) {
        int a = 1;
        while (peoples.size() > 1) {
            for (int position = a; position < peoples.size(); position = position + 2)
                peoples.set(position, "-");
            a = (peoples.size() + a) % 2;
            peoples.removeAll(Arrays.asList("-"));
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
}
