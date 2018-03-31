package by.it.fando.jd01_04;

import java.util.Scanner;

public class TaskC {

       private static double[] mergeSort(double[ ] array, int start, int finish) {

        if (start >= finish) return array;
        int i = start;
        int j = finish;
        int op = (i+j)/2;

        while (i<j) {
            while ((i<op) && (array[i]<=array[op])) i++;
            while ((j>op) && (array[j]>=array[op])) i--;

            if (i<j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == op) op = j;
                else if (j == op) op = i;

            }
        }

        mergeSort (array, start, op);
        mergeSort(array,op+1, finish);


        return array;

    }

  

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        double[] array = new double[0];
        mergeSort (array, 0, array.length-1);

    }

}


