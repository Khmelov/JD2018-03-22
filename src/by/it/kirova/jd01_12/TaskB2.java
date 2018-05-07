package by.it.kirova.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имена (через пробел)");
        String names = scanner.nextLine();
        String[] listArray = names.split(" ");

        ArrayList<String> listA = new ArrayList<>(Arrays.asList(listArray));
        LinkedList<String> listL = new LinkedList<>(Arrays.asList(listArray));
        String nameA = process(listA);
        System.out.println("Имя из ListArray: " + nameA);
        String nameL = process(listL);
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
