package by.it.lyukovich.jd_01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<Short> e = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            e.add((short) (i * 2));
        }
        System.out.println("e " + e.toString());

        List<Short> added = new ArrayList<>();
        e.addAll(added);
        System.out.println("ADDED" + added.toString());
        e.removeAll(added);
        System.out.println(e.size() +" " + e.toString());
    }
}