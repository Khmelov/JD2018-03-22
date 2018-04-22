package by.it.volchek.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.*;


/**
 * Created by volchek on 12.04.18.
 */
public class BeanTester {
    public static void main(String[] args) {
        Class<Bean> b = Bean.class;
        Method[] methods = b.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                try {


                    Object[] paramV = {method.getAnnotation(Param.class).a(), method.getAnnotation(Param.class).b()};
                    System.out.println(method.getName() + " " + method.invoke(b.getDeclaredConstructor().newInstance(), paramV));
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        }
    }
}




