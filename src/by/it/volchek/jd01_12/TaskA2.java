package by.it.volchek.jd01_12;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by volchek on 17.04.18.
 */
public class TaskA2 {
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result= new HashSet<>();
     result.addAll(a);
        result.addAll(b);
        return result;
    }
    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result= new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,4,5,6,5,4,7,8,8,8));
        Set<Integer> b = new HashSet<>(Arrays.asList(9,10,11,12,13,14,15,7,6,5));
        System.out.println(a);
        System.out.println(b);
        System.out.println(getUnion(a,b));
        System.out.println(getCross(a,b));

    }
}
