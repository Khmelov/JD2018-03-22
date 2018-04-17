package by.it.danilevich.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> strString =String.class;
        Method[] methods = strString.getDeclaredMethods();

         for (Method method : methods ) {
             if (!Modifier.isStatic(method.getModifiers())){
                 System.out.println(method.getName());
            }

        }
    }



}
