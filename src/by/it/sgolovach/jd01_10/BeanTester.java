package by.it.sgolovach.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) {

        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();

        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Param.class)) {
                    Param params = method.getAnnotation(Param.class);
                    Object o;
                    o = beanClass.getDeclaredConstructor().newInstance();
                    System.out.println(method.getName() + " result = " + method.invoke(o, params.a(), params.b()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
