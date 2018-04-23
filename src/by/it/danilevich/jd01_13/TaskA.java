package by.it.danilevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try{
            if (Math.random()>0.5)
                new HashMap<String,String>(null);
            else
                Integer.parseInt("hello");
        }
        catch (NumberFormatException | NullPointerException ex){
         String name = ex.getClass().getName();
         StackTraceElement[] stackTrace = ex.getStackTrace();
         for (StackTraceElement st:stackTrace){
             if (TaskA.class.getName().equals(st.getClassName())){
                 String classname = st.getClassName();
                 int number = st.getLineNumber();
                 System.out.printf("name: %s\n" + "class: %s\n"+"line: %d",name, classname,number);
                 break;
             }

         }
        }
    }
}
