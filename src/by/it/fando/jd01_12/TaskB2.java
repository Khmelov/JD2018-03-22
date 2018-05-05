package by.it.fando.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Иванов","Петров","Сидоров","Федотов","Никитин");
        ArrayList<String> array = new ArrayList<>(list);
        System.out.println("Имя из ArrayList: "+process(array));
        LinkedList<String> linked = new LinkedList<>(list);
        System.out.println("Имя из LinkedList: "+process(linked));
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
