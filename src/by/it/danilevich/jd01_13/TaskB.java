package by.it.danilevich.jd01_13;

import java.util.*;

public class TaskB {
    public static void main(String[] args){

        String rezStr;
      //  List<Double> numbers = new ArrayList<>();
        double rez;
        try{
            double sum=0;
            Scanner sc = new Scanner(System.in);
                while (!(rezStr = sc.next()).equals("END")){
                rez = Double.parseDouble(rezStr);
            //    numbers.add(rez);
                sum = sum + rez;
                if (rez<0) throw new ArithmeticException();
                else{
                    rez = Math.sqrt(sum);
                    System.out.println(rez);
                }
             }
        }
        catch (NumberFormatException | NullPointerException |ArithmeticException ex){
         String name = ex.getClass().getName();
         StackTraceElement[] stackTrace = ex.getStackTrace();
         for (StackTraceElement st:stackTrace){
             if (TaskB.class.getName().equals(st.getClassName())){
                 String classname = st.getClassName();
                 int number = st.getLineNumber();
                 System.out.printf("name: %s\n" + "class: %s\n"+"line: %d",name, classname,number);
                 break;
             }

         }
        }
    }
}
