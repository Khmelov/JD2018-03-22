package by.it.poprugo.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();

        //StringBuilder sb=new StringBuilder(); //we can use accelerate running

        for (Method method : methods) {
            //if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
            if (Modifier.isPublic(method.getModifiers())) {
                String res = method.toString().replaceAll("java.lang.Math.", "");
                System.out.println(res); //print out all the methods of Mass
                //System.out.println(method.getModifiers());
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                String res = field.toString().replaceAll("java.lang.Math.", "");
                System.out.println(res); //print out all the methods of Mass
            }
        }
    }
}