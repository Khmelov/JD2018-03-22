package by.it.shvedov.jd01_03;

public class Helper {
    static double findMin(double[] arr){
        if(0==arr.length){
            return Double.MIN_VALUE;
        }
        else{
            double min=arr[0];
            for(double m: arr){
                if (min>m) m=min;


            }
            return min;
        }

    }
    static double findMax(double[] arr){
        if(0==arr.length){
        return Double.MAX_VALUE;
        }
        else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }

    }
    static void sort(double[] arr, boolean r){
        for (int i = 0; i < arr.length-1; i++)
            for (int j = i+1; j <arr.length ; j++)
                if(r && arr[i]>arr[j] || !r && arr[i]<arr[j]){
                    double m=arr[i];
                    arr[i]=arr[j];
                    arr[j]=m;
                }

    }

}
