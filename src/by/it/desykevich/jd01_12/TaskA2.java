package by.it.desykevich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {

    private static Set<Integer> getUnion (Set<Integer>a,Set<Integer>b){
       Set<Integer> result =new HashSet<>(a);
       result.addAll(b);
       return result;
    }

    private static Set<Integer>getCross(Set<Integer> a, Set<Integer> b)
    {
        Set<Integer>result=new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        Set<Integer> b=new HashSet<>(Arrays.asList(8,2,10,4,5,7,7,8));
        System.out.println(a);
        System.out.println(b);
        Set<Integer> c=getUnion(a,b);
        System.out.println(c);
        Set<Integer> d=getCross(a,b);
        System.out.println(d);
    }
}
