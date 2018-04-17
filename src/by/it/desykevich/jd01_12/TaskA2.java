package by.it.desykevich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {

    private static Set<Integer> getCross (Set<Integer>a,Set<Integer>b){
       Set<Integer> result =new HashSet<>();
       result.addAll(a);
       result.removeAll(b);
       return result;
    }
    public static void main(String[] args) {
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Set<Integer> b=new HashSet<>(Arrays.asList(8,2,10,4,5,7,7,8));
        System.out.println(a);
        System.out.println(b);
        Set<Integer> c=getCross(a,b);
        System.out.println(c);
    }
}
