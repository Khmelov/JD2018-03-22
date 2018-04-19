package by.it.kovko.jd01_12;

import java.util.*;

public class TaskB2 {
    static String process(ArrayList<String> peoples){
        int start=1;
        //System.out.println(peoples.toString());
        while(peoples.size()>1){
            for (int index=start;index<peoples.size();index+=2)
                peoples.set(index,"DELETE");
            start=(peoples.size()+start)%2;
            peoples.removeAll(Arrays.asList("DELETE"));
            //System.out.println(start + peoples.toString());
        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        while (peoples.size()>1){
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        List<String> lll = Arrays.asList("n1","n2","n3","n4","n5","n6","n7");
        ArrayList<String> alist = new ArrayList<>(lll);
        LinkedList<String> llist = new LinkedList<>(lll);

        System.out.println("Alist: "+process(alist));
        System.out.println("Llist: "+process(llist));
    }
}
