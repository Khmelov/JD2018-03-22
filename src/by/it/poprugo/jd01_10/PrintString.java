package by.it.poprugo.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                System.out.println(method);
            }
        }
    }
}
