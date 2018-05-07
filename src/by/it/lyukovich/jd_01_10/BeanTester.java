package by.it.lyukovich.jd_01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) {
        Class<Bean> beanClass= Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        try {
            for (Method m : methods) {
                //Поиск аннотированных методов
                if (m.isAnnotationPresent(Param.class)) {
                    Param params = m.getAnnotation(Param.class);
                    Object obj = beanClass.getDeclaredConstructor().newInstance();
                    System.out.println(m.getName() + " res = " + m.invoke(obj, params.a(), params.b()));
                    } }
        } catch (Exception exc) {exc.printStackTrace();
        }
    }
}
