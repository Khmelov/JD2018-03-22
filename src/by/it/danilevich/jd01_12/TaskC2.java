package by.it.danilevich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    public static void main(String[] args) {

        Set<? extends Number>a = new HashSet<>(Arrays.asList(1, 2.0, 3, 4, 5.0, 6, 7, 8888, 97, 25, 23 , 14, 54, 68, 77));
        Set<? extends Number>b = new HashSet<>(Arrays.asList(0, -2, -3, 4, 5, 6, 7, 8888, -97, -25, -23 , -14, -54, -68, -77));
       Set<? extends Number>a2 = new HashSet<>(Arrays.asList(15, 22, 30));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        Set<? extends Number> c= getUnion(a,a2,b);
        System.out.println("all elemements = " + c);
        Set<? extends Number> d = getCross(a,b);
        System.out.println(" cross elements" + d);

    }


    private static Set<? extends Number> getUnion(Set<? extends Number>... a){
        Set<? extends Number> rez= new HashSet<>();
        for (Set el:a) {
            rez.addAll(el);
        }
        return rez;

    }

    @SafeVarargs
    private static Set<? extends Number> getCross(Set<? extends Number>... a){
        if (a.length> 0){
            Set<? extends Number> rez= new HashSet<>(a[0]);
            for (int i =1; i<a.length;i++){
                rez.retainAll(a[i]);
            }
            return rez;
        }
        return null;
    }
}
