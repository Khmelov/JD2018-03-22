package by.it.lyukovich.jd_01_03;

import java.sql.SQLOutput;

public class InOut {
    static double[ ] getArray(String line){
        line.trim();
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++)
            res[i] = Double.parseDouble(strArr[i]);
        return res;

    }

    static void printArray(double[] arr){
        for (double element : arr){
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int columnCount){
        //V[1] = 12.111 V[3] = 12.111 V[3] = 12.111
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if (((i+1)%columnCount==0) || (i+1==arr.length))
            System.out.println();
        }
    }
    static void printMin(double[] arr){
        double min;
        min = Helper.findMin(arr);
        System.out.println("Минимальное " +min);
    }
    static void printMax(double[] arr){
        double max;
        max = Helper.findMax(arr);
        System.out.println("Максимальное " +max );
    }
    static void printSorted(double[] arr){
        Helper.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }

    }

}
