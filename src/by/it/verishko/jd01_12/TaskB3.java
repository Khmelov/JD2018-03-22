package by.it.verishko.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Пер", "Втор", "Трет", "Четв", "Пят", "Шест", "Седм", "Вос");
        ArrayList<String> arrayList = new ArrayList<>(list);
        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.println("arrayList: " + process(arrayList));
        System.out.println("linkedList: " + process(linkedList));
    }

    private static String process(ArrayList<String> peoples) {
        int a = 1;
        while (peoples.size() > 1) {
            for (int position = a; position < peoples.size(); position = position + 2)
                peoples.set(position, "-");
            a = (peoples.size() + a) % 2;
            peoples.removeAll(Collections.singletonList("-"));
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
