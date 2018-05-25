package by.it.lyukovich.jd_01_03;

import java.util.Arrays;

public class Helper {
    static double findMin(double[ ] arr){
        double min=Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
               for (double element : arr) {
            if (min>element) min=element;
            if(max<element) max=element;
        }
        return min;

    }
    static double findMax(double[ ] arr){
        double min=Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (min>element) min=element;
            if(max<element) max=element;
        }
        return max;
    }
    public static void sort(double[ ] arr){
        boolean swap=true;
        int size=arr.length-1;
        while (swap){
            swap=false;
            for (int i=0;i<size;++i){
                if (arr[i]>arr[i+1]){
                    double temp=arr[i]; arr[i]=arr[i+1]; arr[i+1]=temp;
                    swap=true;
                }
            }
            --size;
        }

    }

}
