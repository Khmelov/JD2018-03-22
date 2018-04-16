package by.it.kovko.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Runner {
    public static void main(String[] args) {
        Set<Short> a = new SetC<>();
        Set<Short> e = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            e.add((short) (i * 2));
            a.add((short) (i * 2));
        }
        System.out.println("e " + e.toString());
        System.out.println("a " + a.toString());

        List<Short> added = new ArrayList<>();
//        added.add(null);
//        added.add(null);
//        added.add((short) 1000);
//        added.add((short) 1000);
//        added.add((short) 1001);
//        added.add((short) 1002);
        e.addAll(added);
        a.addAll(added);
        System.out.println("ADDED" + added.toString());
        a.removeAll(added);
//        a.remove(null);
//        a.remove((short)1000);
//        a.remove((short)1001);
//        a.remove((short)1002);
        e.removeAll(added);
        System.out.println(a.size() +" " + a.toString());
        System.out.println(e.size() +" " + e.toString());
    }
}
