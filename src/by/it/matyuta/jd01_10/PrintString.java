package by.it.matyuta.jd01_10;

import java.lang.reflect.Method;

public class PrintString {

    public static void main(String[] args) {
       Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        for (Method method : methods) {
            String methodName = method.getName();
            System.out.println(methodName);
        }

    }

}
