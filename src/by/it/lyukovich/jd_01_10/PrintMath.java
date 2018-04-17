package by.it.lyukovich.jd_01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Method[] methods = mathClass.getMethods();
        for (Method method : methods){
            if (Modifier.isPublic(method.getModifiers())){
            sb.append(method.toString().replaceAll("java.lang.Math.", "")).append("\n");}}
            System.out.println(sb);


        Field[] fields = mathClass.getFields();
        for (Field field : fields){
            if (Modifier.isPublic(field.getModifiers())){
                sb2.append(field.toString().replaceAll("java.lang.Math.", "")).append("\n");}}
        System.out.println(sb2);
    }
}
