package by.it.pashkevich.jd01_05.jd01_05;

import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        //     step2();
    }

    private static void step1 () {
        double y = 0;
        for (double a = 0; a <= 2.0; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += (pow(7, a)-cos(x));
            }
        }
        System.out.println(y);
    }
}
