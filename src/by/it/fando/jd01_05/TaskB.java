package by.it.fando.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double[] arr={1,2,3,4,5,6};
        double y=0;
        for (double a=0; a<=2; a=a+0.2) {
            for (double anArr : arr) {
                y = y + pow(7, 2) - cos(anArr);
            }
            System.out.printf("for a=%4.2f y=%8.6f\n",a,y);

        }

    }

    private static void step2() {
        double a=0;
        String s="условия не выполнены";

        for (double x = -5.5; x < 2; x=x+0.5) {

            if (x/2>-2 && x/2<=0.2) {
                if (x / 2 > -2 && x / 2 <= -1)
                    a = log10(abs(sin(x * x) + 2.74));

                if (x / 2 > -1 && x / 2 < 0.2)
                    a = log10(abs(cos(x * x) + 2.74));

                if (x / 2 == 0.2)
                    a = log10(abs(1 / tan(x * x) + 2.74));

                System.out.println("Для x/2= " + x + "  a=" + a);
            }
            else {
                System.out.println("Для x/2= "+x+"  a= "+s);
            }
        }


    }


}
