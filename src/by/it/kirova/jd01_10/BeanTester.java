package by.it.kirova.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) {
        try{
            Class<Bean> beanClass = Bean.class;
            Method[] methods = beanClass.getDeclaredMethods();
            Object b = beanClass.getConstructor().newInstance();
            for (Method method : methods) {
                Param aa = method.getAnnotation(Param.class);
                if (aa != null) {
                    double res = (double) method.invoke(b, aa.a(), aa.b());
                    System.out.println(method.getName() + " " + res);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

