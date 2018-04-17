package by.it.shvedov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods=stringClass.getMethods();
        for (Method method: methods) {
            if((method.getModifiers() & Modifier.STATIC)!= Modifier.STATIC){
                String res= method.toString().replaceAll("java.lang.String.","");
                System.out.println(res);
            }

        }

    }
}
