package by.it.kovko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        int xMin=1, xMax=6;
        double aMin=0, aMax=2, aStep=0.2;
        step1(xMin,xMax,aMin,aMax,aStep);
        double dxMin=-6, dxMax=2, xStep=0.5;
        step2(dxMin,dxMax,xStep);
    }

    static private void step1(int xMin, int xMax, double aMin, double aMax, double aStep){
        double sum;
        //double arr[] = {0.0,0.2,0.4,0.6,0.8,1.0,1.2,1.4,1.6,1.8,2.0};
        //for (double a : arr) {
        for (double a = aMin; a <=aMax; a=a+aStep) {
            sum=0;
            for (int x = xMin; x <= xMax; x++) {
                sum += (pow(7, a) - cos(x));
            }
            System.out.println("При а="+a+" Сумма y="+sum);
        }
    }

    static private void step2(double xMin, double xMax, double xStep){
        double b, xn;
        for (double x = xMin; x < xMax; x+=xStep) {
            xn=x/2;
            System.out.print("При x/2=" + xn + " ");

            if (xn>-2 && xn<=0.2){
                if (xn<=-1){
                    b=sin(x*x);
                } else if(xn<0.2){
                    b=cos(x*x);
                } else {
                    b=1/tan(x*x);
                    System.out.println("tangens");
                }
                System.out.println("a=" + log10(abs(b+2.74)));
            } else{
                System.out.println("вычисления не определены");
            }
        }
    }



}
