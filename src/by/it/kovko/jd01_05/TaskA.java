package by.it.kovko.jd01_05;
import static java.lang.Math.*;
public class TaskA {
    public static void main(String[] args) {

        double x=0.3, a=756.13;
        System.out.println(step1(x, a));
        //System.out.println("4516");

        double b=0.371;
        a=1.21;
        System.out.println(step2(a,b));
        x=12.1;
        double aMin=-5, aMax=12, aStep=3.75;
        System.out.println("A3:\t"+step3(x,aMin,aMax,aStep));
    }

    private static double step1(double x, double a){
        return cos(pow((x*x+PI/6),5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
    }

    private static double step2(double a, double b){
        return tan(pow((a+b),2))-pow((a+1.5),1.0/3)+a*pow(b,5)-b/log(a*a);
    }

    private static double step3(double x, double aMin, double aMax, double aStep){
        double res=0, f,a;
        for (a= aMin; a <= aMax; a+=aStep){
            f=pow(E,a*x)-3.45*a;
            //res+=f;
            System.out.println("При а="+a+" f="+f);
        }
        return res;
    }

}
