package by.it.fando.jd01_05;

import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        double start = 5.33;
        double end = 9;
        double step = 0.2;

        double n = (end-start)/step+1;
        int k=(int)n;

        double[] res = new double[k];
        int i=0;

        for (double x = start; x <=end; x=x+step) {
            double z=pow((x*x+4.5),1.0/3);
            res[i]=z;
            i++;
            System.out.printf("%5.2f",z);
        }

    }


    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name,i,arr[i]);
            if ((i+1)%columnCount==0 || (i+1==arr.length))
                System.out.println();
        }

    }





    private static void step2() {




    }
}
