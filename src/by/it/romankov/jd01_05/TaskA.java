package by.it.romankov.jd01_05;
import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }
    private static void step1(){
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow((x*x+PI/6),5));
        z=z-sqrt(x*a*a*a);

    }
    private static void step2(){
        double a;


    }
    private static void step3(){

        double x =12.1;
        for ( double a=-5; a<=12;a=a+3.75 ){
            double f = exp(a*x)-3.45*a;
            System.out.printf("For a=%6.2f F=%g\n",a,f);
        }


    }
}
