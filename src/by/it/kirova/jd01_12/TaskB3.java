package by.it.kirova.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            list.add(Integer.toString(i));
        }
        ArrayList<String> listA = new ArrayList<>(list);
        LinkedList<String> listL = new LinkedList<>(list);

        Timer t = new Timer();
        String nameA = process(listA);
        System.out.println("Перебор 4096 значений в ListArray " + t);
        System.out.println("Имя из ListArray: " + nameA);
        String nameL = process(listL);
        System.out.println("Перебор 4096 значений в LinkedList " + t);
        System.out.println("Имя из LinkedList: " + nameL);
    }




    private static String process(ArrayList<String> peoples) {
        return processImpl(peoples);
    }

    private static String processImpl(List<String> peoples) {
        Iterator iterator = peoples.iterator();
        if (!iterator.hasNext())
            return null;

        boolean removed = true;
        while (true) {
            if (hasNotMoreThenOneValue(peoples))
                break;
            iterator = peoples.iterator();
            while (iterator.hasNext()) {
                if (removed)
                    iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    removed = true;
                } else
                    removed = false;
            }
        }
        return peoples.get(0);
    }

    private static boolean hasNotMoreThenOneValue(List<String> peoples) {
        Iterator iterator = peoples.iterator();
        if (iterator.hasNext())
            iterator.next();
        return !iterator.hasNext();

    }


    private static String process(LinkedList<String> peoples) {
        return processImpl(peoples);
    }
}


