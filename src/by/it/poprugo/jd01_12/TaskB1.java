package by.it.poprugo.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TaskB1 {

    public static void main(String[] args) {
//        Set<String> wordsIn=new Set<>(Arrays.asList("one", "mine", "isn't", "end"));
        HashSet<String> wordsIn = new HashSet<>(Arrays.asList("one", "mine", "isn't", "end"));
        String str = new String();
        Iterator<String> iterator = wordsIn.iterator();
        while (iterator.hasNext()) {
            str = iterator.next();
            int count = 1;
            while (iterator.hasNext())
                if (str.equals(iterator.next())) count++;
            System.out.println(str+" is "+count+" times");
        }
    }
}
