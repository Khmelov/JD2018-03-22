package by.it.shvedov.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    public static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++ ){
                y=pow(7,a)-cos(x);
            }
            System.out.printf("При a=%-6.2f y=%g\n",a,y);
        }
    }
    public static void step2(){
        double a, b = 0;
        for(double x=-6; x<2; x=x+0.2){
            if(x/2>-2 && x/2<=-1) b=sin(pow(x,2));
            else if (x/2>-1 && x/2<0.2) b=cos(pow(x,2));
            else if (x/2==0.2) b=atan(pow(x,2));
            a=log(abs(b+2.74));
            System.out.printf("При x=%-6.2f b=%-6.2f a=%g\n",x,b,a);
        }
    }
}
