package by.it.romankov.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
      double  min = Double.MIN_VALUE;
        for ( int i = 0; i <arr.length ; i++ ) {
            if(min>arr[i])
                min=arr[i];
        }
       return min;

    }
    static double findMax(double[ ] arr){
        double  max = arr[0];
        for ( int i = 0; i <arr.length ; i++ ) {
            if(max<arr[i])
                max=arr[i];
        }
        return max;

    }
    static void sort(double[ ] arr){

        for(int i=0;i<arr.length;i++){
            int m = i;
            for(int j=i;j<arr.length;j++){
                if(arr[m] > arr[j])
                    m = j;
            }
            double t = arr[m];
            arr[m] = arr[i];
            arr[i] = t;
        }

        }
    }

