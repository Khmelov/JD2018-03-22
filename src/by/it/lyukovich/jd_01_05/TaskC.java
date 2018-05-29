package by.it.lyukovich.jd_01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1(5);
    }
    private static void step1(int columnCount){
        int g=0;
        int g2=0;
        double[] arr = new double[35];
            for (double x = 5.33; x < 9; x=x+0.1) {
                double z=pow((pow(x,2)+4.5),1.0/3);
                if (g<arr.length){
                    arr[g]=z;
                    g=g+1;
                    if (z>3.5){
                        g2=g2+1;
                    }
                }
                // System.out.printf("V(%-2d): %-10f", );
            }
        System.out.println("Массив A[]");
            for (int i = 0; i < arr.length; i++) {
            System.out.printf("A[ %-2d] = %-14.5f ", i, arr[i]);
            if (((i+1)%columnCount==0) || (i+1==arr.length))
                System.out.println();
        }
        System.out.println("");
        double[] arr2=new double[g2];
        g2=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>3.5){
                arr2[g2]=arr[i];
                g2=g2+1;
            }
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("B[ %-2d] = %-14.5f ", i, arr2[i]);
            if (((i+1)%columnCount==0) || (i+1==arr2.length))
                System.out.println();
        }

    }




}
