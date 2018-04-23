package by.it.danilevich.jd01_10;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;


public class BeanTester {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Object bean = null;
        try {
            bean = Bean.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Class beanClass= bean.getClass();

        Method[] methods = beanClass.getDeclaredMethods();
        for (Method m : methods) {
            Annotation[] annotations;
            annotations = m.getAnnotations();
            for (Annotation a1 : annotations){
             //   Object res = m.invoke(bean, new LinkedHashMap<>());
             //   System.out.println(m.getName() + " " + res);
                //m.invoke(bean,a.annotationType().getFields());
            }
        }


    }
}
