package by.it.pashkevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = String.class.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())) {
                sb.append(method.getName()).append('\n');
            }
        }
        System.out.println(sb);
    }
}

