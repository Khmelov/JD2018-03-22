package by.it.uskoryaev.jd01_12;

import java.util.*;

public class TaskA1 {
   private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> gredes){
//        List<Integer> bsd = Arrays.asList(1,2,3);
//        gredes.removeIf(i->i<4);

        Iterator<Integer> iterator = gredes.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();
            if (value<4)iterator.remove();
        }
    }

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        for (int i = 0; i <25 ; i++) {
            taskA1.grades.add((int) Math.ceil(Math.random()*10));
            //taskA1.grades.add((int) Math.random()*10+1);
        }
        System.out.println(taskA1.grades);
        taskA1.clearBad(taskA1.grades);
        System.out.println(taskA1.grades);


    }


}
