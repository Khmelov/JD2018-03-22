package by.it.lyukovich.jd_01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (int i = 1; i < 7; i++) {
                y = y + pow(7, a) - cos(i);
            }
            System.out.printf("For a=%-6f y=%-6f\n",a,y);
        }
    }
    private static void step2(){
        for (double x = -5.5; x < 2; x=x+0.5) {
            if (x/2>-2 & x/2<=-1){
                double b=sin(pow(x,2));
                double a=log10(abs(b+2.74));
                System.out.printf("При x/2=%-2f, a = %-16e\n", x / 2, a);
            }
            else if (x/2>-1 & x/2<0.2){
                double b=cos(pow(x,2));
                double a=log10(abs(b+2.74));
                System.out.printf("При x/2=%-2f, a = %-16e\n", x / 2, a);
            }
            else if (x/2==0.2){
                double b=1.0 / tan(pow(x,2));
                double a=log10(abs(b+2.74));
                System.out.printf("При x/2=%-2f, a = %-16e\n", x / 2.0, a);
            } else{
                System.out.printf("При x/2=%-2f вычисления не определены\n",x/2);
            }


        }
    }


}
