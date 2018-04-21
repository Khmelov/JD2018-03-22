package by.it.poprugo.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
//        a.addAll(b);
//        return a; - "сломался" а таким образом
        Set<Integer> result=new HashSet<>();
        result.addAll(a);
        result.addAll(b);
        return result; //можно и через for each, но IDEA подскажет поменять на такой вариант
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
        // !!! надо придумать СВОЙ способ вместо готового метода retainAll(b)
    }

    public static void main(String[] args) {
//        List<Integer> ill=Arrays.asList(1,2,3,4,5,5,6,6,7,7,98,8);
//        Set<Integer> a=new HashSet<>(ill);
//        System.out.println(a);
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,4,5,5,6,6,7,7,8,8));
        Set<Integer> b=new HashSet<>(Arrays.asList(8,9,10,4,5,5,6,6,7,8,9,9,9));
        System.out.println(a);
        System.out.println(b);
        Set<Integer> c=getUnion(a,b);
        System.out.println(c);
        Set<Integer> d=getCross(a,b);
        System.out.println(d);
    }


}
