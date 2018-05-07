package by.it.kovko.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        List<Integer> list = new ArrayList<>();
        double sum=0, sqr=0, num;
        while(!(str = scanner.next()).equals("END")) {
            try{
                num=Double.parseDouble(str);
                sum+=num;
                if (sum<0)
                    throw new ArithmeticException();
                sqr=Math.sqrt(sum);
                System.out.println(num+"\t"+sqr);

            } catch ( NumberFormatException | ArithmeticException e){
                String name = e.getClass().getName();
                System.out.println("name: "+ name);
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.println("class: " + element.getClassName() + "\n" + "line: " + element.getLineNumber());
                        break;
                    }
                }
            }
        }
        System.out.println("end");
    }
}
