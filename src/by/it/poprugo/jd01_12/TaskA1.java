package by.it.poprugo.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    void clearBad(List<Integer> grades) {
        //grades.removeIf(i -> i < 4); /* это лямбда: для Integer i при условии i<4, возвращаем true, соответсвенно удалит*/
        //List<Integer> можно сделать через ArrayList!
        Iterator<Integer> iterator=grades.iterator();
        while (iterator.hasNext()){ //подсказка от IDEA: заменить на Collection; Alt-Enter и мы - обратно с лямбдой
            Integer value = iterator.next();
            if (value<4) iterator.remove();
        }
        /*через for each не получится, т.к. в for each запускается итератор (это и есть по сути итератор),
         * но как только он удалит к.-л. элемент, то соственно итератор "сломается" */

    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 25; i++) {
            task.grades.add((int) Math.ceil(Math.random() * 10));
        }
        System.out.println(task.grades);
        //две записи ниже приведут к одинаковому результату: от 1 до 10
        //task.grades.add((int) (Math.random()*10)+1);
        //task.grades.add((int) Math.ceil(Math.random()*10));
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }
}
