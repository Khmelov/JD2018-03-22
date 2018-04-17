package by.it.poprugo.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    @Param(a=3, b=5)
    public static void main(String[] args) {
        //вытвщить класс Bean
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            //Param x1 = method.getAnnotation(Bean.avg(3, 5));
            //System.out.println(method.invoke());

            //у ребят получилось, когда вставили track edge (?) try catch (!?)
        }
    }
}
