package by.it.lyukovich.jd_01_12;

import java.util.*;

@SuppressWarnings("ALL")
public class TaskB3 {
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

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jack", "Lisa","Max","Debra","Tony","Fay");
        List<String> bigtask = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            Random rand = new Random();
            int  n = rand.nextInt(7) + 0;
            String tmpname = names.get(n);
            bigtask.add(tmpname);
        }
        ArrayList<String> aList = new ArrayList<>(bigtask);
        LinkedList<String> lList = new LinkedList<>(bigtask);
        System.out.println("Alist: "+process(aList));
        System.out.println("Finished Array");
        System.out.println("Llist: "+process(lList));
        System.out.println("Finished Linked");

    }
}
