package by.it.uskoryaev.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        List<Double> listNumb = new ArrayList<>();
        double numCor=0, numb =0 ,result;

            while (!(str = scanner.nextLine()).equals("end"))
            try {
                numb = Double.parseDouble(str);
                listNumb.add(numb);
                numCor+=numb;
                result = Math.sqrt(numCor);
                if (Double.isNaN(result)) {
                    throw new ArithmeticException();
                }
                System.out.println(numb+"\n"+result);

        }catch (ArithmeticException | NumberFormatException e){
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                    System.out.println("name: "+e.getClass().getName());
                    System.out.println("class: "+stackTraceElement.getClassName());
                    System.out.println("line: "+stackTraceElement.getLineNumber());
                    break;
                }
            }
        }
    }
}
