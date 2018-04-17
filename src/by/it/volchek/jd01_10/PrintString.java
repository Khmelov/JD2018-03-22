package by.it.volchek.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by volchek on 12.04.18.
 */
public class PrintString {
    public static void main(String[] args) {


        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers()))
                System.out.println(method.getName());

        }
    }
}


/*
*  public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        mathClass.getFields();
        Method[] methods = mathClass.getDeclaredMethods();
        StringBuilder sb =new StringBuilder();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers()))
                sb.append(method.toString().replaceAll("java.lang.Math.","")+"\n");

        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers()))
                sb.append(field.toString().replaceAll("java.lang.Math.","")+"\n");

        }
        System.out.println(sb.toString());
    }
* */