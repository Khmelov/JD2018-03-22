package by.it.pashkevich.jd01_10;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)



public @interface Param {
    int a();
    int b();
}
