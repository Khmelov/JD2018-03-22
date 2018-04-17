package by.it.danilevich.jd01_10;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;


public class BeanTester {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object bean = Bean.class.newInstance();
        Class beanClass= bean.getClass();

        Method[] methods = beanClass.getDeclaredMethods();
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();


            for (Annotation a : annotations){

                //m.invoke(bean,a.annotationType().getFields());
            }
            //System.out.println(m.getParameterCount());

           // System.out.println(rez);

        }


    }
}
