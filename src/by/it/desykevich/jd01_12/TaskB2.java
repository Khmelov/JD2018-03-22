package by.it.desykevich.jd01_12;

import java.util.*;

public class TaskB2 {
    private static void removal(List<String> peoples) {
        Iterator<String> iterator;
        boolean f = true;
        while (peoples.size() != 1) {
            iterator = peoples.iterator();
            if (!f && iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
            while (iterator.hasNext()) {
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();

                    f = !iterator.hasNext();
                }
            }
            System.out.println(peoples);
        }
    }

    private static String process(ArrayList<String> peoples) {
        removal(peoples);
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        System.out.println(peoples);
        removal(peoples);
        return peoples.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<String> arrayPeople = new ArrayList<>();
        LinkedList<String> linkedPeople = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            arrayPeople.add("n" + i);
            linkedPeople.add("n" + i);

        }
        //хотел добавить время выполнения методов, но что-то пошло не так.
        System.out.println(process(arrayPeople));
        System.out.println(process(linkedPeople));


    }
}
