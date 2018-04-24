package by.it.lyukovich.jd_01_12;

import java.util.*;

public class TaskA2 {
    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> a= new HashSet<>(Arrays.asList());
        Set<Integer> b= new TreeSet<>(Arrays.asList());
        int n;
        int m;
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();

            n =  rand.nextInt(10)+1;
            m =  rand.nextInt(10)+1;
            a.add(n);
            b.add(m);
        }

        System.out.println(a);
        System.out.println(b);
        Set<Integer> c = getUnion(a,b);
        Set<Integer> d = getCross(a,b);
        System.out.println(c);
        System.out.println(d);
    }
}
