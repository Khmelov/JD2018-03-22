package by.it.volchek.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by volchek on 18.04.18.
 */
public class TaskC2 {
    static <T extends Number> Set<T>  getUnion(Set<T>...args){
        Set<T> result= new HashSet<>();
        for (Set<T> arg : args) {
            result.addAll(arg);
        }

        return result;
    }
    static <T extends Number> Set<T> getCross(Set<T>...args){

        Set<T> result= new HashSet<>(args[0]);
        for (int i = 1; i <args.length ; i++) {
            result.retainAll(args[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,4,5,6,5,4,7,8,8,8));
        Set<Integer> b = new HashSet<>(Arrays.asList(9,10,11,12,13,14,15,7,6,5));
        Set<Double> c = new HashSet<>(Arrays.asList(2.4,2.9,5.6));
        System.out.println(a);
        System.out.println(b);
        //Set<Integer> res = getUnion(a,b,c);
        //Set<Integer> res1 = getCross(a,b,c);
        //System.out.println(res);
       //]System.out.println(res1);

    }
}
