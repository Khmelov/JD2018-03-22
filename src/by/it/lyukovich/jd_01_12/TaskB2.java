package by.it.lyukovich.jd_01_12;

import java.util.*;
@SuppressWarnings("ALL")
public class TaskB2 {

    static String process(ArrayList<String> peoples){
        return processCountOut(peoples);
    }
    static String process(LinkedList<String> peoples){
        return processCountOut(peoples);
    }
    private static String processCountOut(List<String> peoples) {
        int peoplesSize = peoples.size();
        boolean start = false;
        while(peoples.size()>1){
            Iterator<String> iterator = peoples.iterator();
            if ((peoples.size()<peoplesSize) && (start))  {
                iterator.next();
                iterator.remove();
                start=false;
            }
            while (iterator.hasNext()){
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                else  start = true;
            }
        }
        return peoples.get(0);

    }
}
