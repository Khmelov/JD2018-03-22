package by.it.desykevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
//            Modifier.isPublic(method.getModifiers())
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                String res = method.toString().replaceAll("java.lang.Math.", "");
                System.out.println(method);
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