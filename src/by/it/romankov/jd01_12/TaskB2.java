package by.it.romankov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    static String process (ArrayList <String> peoples) {
        List<String> list = new ArrayList<>(peoples);
        boolean del = false;
        while (list.size()>1){
            Iterator <String> iterator = list.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if(del)
                    iterator.remove();
                del=!del;
            }
        }
        return list.get(0);
    }

    static String process (LinkedList<String> peoples) {
        List<String> list = new ArrayList<>(peoples);
        boolean del = false;
        while (list.size()>1){
            Iterator <String> iterator = list.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if(del)
                    iterator.remove();
                del=!del;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        list.add("roma");
        list.add("Serop");
        list.add("Ivanov");
        list.add("Put");
        list.add("vova");
        list.add("wert");
        list.add("wertup");
        list.add("sashka");

        System.out.println(process((ArrayList<String>) list));

        linkedList.add("roma");
        linkedList.add("Serop");
        linkedList.add("Ivanov");
        linkedList.add("Put");
        linkedList.add("vova");
        linkedList.add("wert");
        linkedList.add("wertup");
        linkedList.add("sashka");

        System.out.println(process((LinkedList<String>) linkedList));





    }
}

