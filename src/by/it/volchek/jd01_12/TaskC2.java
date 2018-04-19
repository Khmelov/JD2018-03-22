package by.it.volchek.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by volchek on 18.04.18.
 */
public class TaskC2 {
    static Set  getUnion(Set...args){
        Set result= new HashSet<>();
        for (Set arg : args) {
            result.addAll(arg);
        }

        return result;
    }
    static Set getCross(Set...args){

        Set result= new HashSet<>(args[0]);
        for (int i = 1; i <args.length ; i++) {
            result.retainAll(args[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,4,5,6,5,4,7,8,8,8));
        Set<Integer> b = new HashSet<>(Arrays.asList(9,10,11,12,13,14,15,7,6,5));
        Set<String> c = new HashSet<>(Arrays.asList("sdfsdf","sdfs"));
        System.out.println(a);
        System.out.println(b);
        System.out.println(getUnion(a,b,c));
       System.out.println(getCross(a,b,c));

    }
}
