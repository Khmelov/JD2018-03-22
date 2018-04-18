package by.it.desykevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                String str = method.toString();
                String result = str.replace("java.lang.Math.","");
                System.out.println(result);
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                String str = field.toString();
                String result = str.replace("java.lang.Math.", "");
                System.out.println(result);
            }

        }
    }
}