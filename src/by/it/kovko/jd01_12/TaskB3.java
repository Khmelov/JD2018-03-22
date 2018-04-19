package by.it.kovko.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TaskB3 {
    static String process(LinkedList<String> peoples){
        while (peoples.size()>1){
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }
    static String process(ArrayList<String> peoples){
        int start=1;
        while(peoples.size()>1){
            for (int index=start;index<peoples.size();index+=2)
                peoples.set(index,"DELETE");
            start=(peoples.size()+start)%2;
            peoples.removeAll(Arrays.asList("DELETE"));
        }
        return peoples.get(0);
    }
}
