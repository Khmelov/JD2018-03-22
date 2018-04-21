package by.it.danilevich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> grades){
       // grades.removeIf(i->(i<4));
        //way 2
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();
            if (value<4) iterator.remove();
        }
    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 25; i++) {
            // task.grades.add((Integer) i);
            task.grades.add((int) (Math.random()*10+1));
        }
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }

}
