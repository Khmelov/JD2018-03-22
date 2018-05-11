package by.it.pashkevich.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    void clearBad(List<Integer> grades) {
        grades.removeIf(i->(i<4));

}

    public static void main(String[] args) {
        TaskA1 task =new TaskA1();
        for (int i = 0; i < 25; i++) {
            task.grades.add((int) Math.ceil(Math.random() * 10));
        }
        task.clearBad(task.grades);
            System.out.println(task.grades);
        }

    }


