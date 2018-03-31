package by.it.kovko.jd01_05;
import static java.lang.Math.*;
public class TaskA {
    public static void main(String[] args) {

        System.out.println("A1:\t"+Task1(0.3, 756.13));

        System.out.println("A2:\t"+Task2(1.21,0.371));

        System.out.println("A3:\t"+Task3(12.1,-5,12,3.75));
    }

    private static double Task1(double x, double a){
        return Math.cos(pow((x*x-Math.PI/6),5))-Math.sqrt(x*a*a*a)-Math.log(abs((a-1.12*x)/4));
    }

    private static double Task2(double a, double b){
        return pow(tan(a+b),2)-pow(a+1.5,1.0/3)+a*pow(b,5)-b/log(a*a);
    }

    private static double Task3(double x, double aMin, double aMax, double aStep){
        double res=0, a;
        for (a= aMin; a <= aMax; a+=aStep)
            res=pow(E,a*x)-3.45*a;
        return res;
    }

}
