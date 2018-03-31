package by.it.kovko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

    }
    static private double Task1(int xMin, int xMax, double aMin, double aMax, double aStep){
        double sum=0;
        for (int x = xMin; x <= xMax; x++) {
            for (double a = aMin; a <aMax; a+=aStep) {
                sum+=(pow(7,a)-cos(x));
            }
        }
        return sum;
    }



}
