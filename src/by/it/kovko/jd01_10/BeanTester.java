package by.it.kovko.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class <Bean> obj = Bean.class;
        Method[] methods = obj.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param p  = method.getAnnotation(Param.class);
                System.out.println(method.getName()+" "+p.a()+" "+p.b());
                System.out.println(method.invoke
                        (obj.getDeclaredConstructor().newInstance(), p.a(), p.b()));
            }
        }
    }
}
