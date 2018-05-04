package by.it.akhmelev.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();
    private void clearBad(List<Integer> grades){

        grades.removeIf(value -> value < 4);
    }

    public static void main(String[] args) {
        TaskA1 task=new TaskA1();
        for (int i = 0; i < 25; i++) {
            task.grades.add((int) (Math.random()*10+1));
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }

}
