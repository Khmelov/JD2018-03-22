package by.it.kirova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;

        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())) {
                String name = method.toString();
                int endIndex = name.indexOf('(');
                name = name.substring(0, endIndex);
                int startIndex = name.lastIndexOf('.');
                name = name.substring(startIndex + 1);
                System.out.println(name);
            }
        }
    }
}
