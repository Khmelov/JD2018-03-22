package by.it.verishko.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Bean> beanClass = Bean.class;
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                System.out.println(method.getName() + Arrays.toString(method.getTypeParameters()));
                System.out.println(method.invoke
                        (beanClass.getDeclaredConstructor().newInstance(), annotation.a(), annotation.b()));
            }
        }
    }
}