package by.it.shvedov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        double res=0;
       List<Integer> list= new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        String chislo;
        try {
            while (!(chislo = scan.next()).equals("end")) {
                Integer element = Integer.valueOf(chislo);
                list.add(element);
            }
            System.out.println(list);
            for (double element : list) {
                res += Math.sqrt(element);
            }
            System.out.println(res);
        }
        catch (NumberFormatException | ArithmeticException e){
            final StackTraceElement[] stackTrace = e.getStackTrace();
            for(StackTraceElement element: stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(" name:%s\n" + " class:%s\n" + " line:%d\n", name, className, number);
                    break;
                }
            }
        }
    }
}
