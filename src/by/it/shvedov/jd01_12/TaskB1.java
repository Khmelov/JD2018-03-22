package by.it.shvedov.jd01_12;

import java.util.*;

public class TaskB1 {
    private List<String> list=new ArrayList<>();
 private  void numberOfRepetitions(List <String> repeats){
 final Iterator<String> iterator= repeats.iterator();
 while(iterator.hasNext()){
     String repeat=iterator.next();
       //  if(repeat.equals(repeat.)){

         //}
 }
 }
    public static void main(String[] args) {
        TaskB1 task= new TaskB1();
        Scanner scan=new Scanner(System.in);
      String str;
        while(!(str=scan.next()).equals("end")) {
            task.list.add(str);
        }
        System.out.println(task.list);
    }
}
