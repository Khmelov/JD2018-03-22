package by.it.shvedov.jd01_05;
import static java.lang.Math.*;
public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
step3();

        }
        public static void step1(){
   double a=756.13, x=0.3, z,k,f;
   f=cos(pow((x*x-PI*6),5));
   k=f-sqrt(x*a*a*a);
   z=k-log10(abs((a-1.12*x)/4));
            System.out.println("z="+z);

    }
    public static void step2(){
            double a=1.21, b=0.371,y;
            y=tan(pow(a+b,2))-pow(a+1.5,1/3)+a*pow(b,5)-b/(log10(a*a));
        System.out.println("y="+y);

    }
public static void step3(){
        double x=1.21, f;
        for(double a=-5; a<=12; a=a+3.75){
           f=exp(a*x)-3.45*a;
            System.out.printf("При a=%-6.2f f=%g\n",a,f);
        }

}

}
