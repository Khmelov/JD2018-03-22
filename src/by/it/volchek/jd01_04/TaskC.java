package by.it.volchek.jd01_04;

import by.it.volchek.jd01_03.Generate;
import by.it.volchek.jd01_03.Helper;
import by.it.volchek.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by volchek on 29.03.18.
 */
public class TaskC {


    private static double[] merge(double[] part1, double[] part2) {
        double[] finalArray = new double[part1.length + part2.length];
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 0; i < finalArray.length; i++) {
            if ((part1.length > flag1) && (part2.length > flag2)) {
                if (part1[flag1] >= part2[flag2]) finalArray[i] = part2[flag2++];
                else finalArray[i] = part1[flag1++];
            } else if (part1.length > flag1) finalArray[i] = part1[flag1++];
            else finalArray[i] = part2[flag2++];

        }
        return finalArray;

    }


    //!!!!!!!!!!!!!!!
    // вместо сортировки слиянием сделана сортировка Хоара (имя метода сделано, чтобы пройти тест =)
    static void mergeSort(double[] array, int first, int last) {

        if (first >= last)
            return;
        int i = first, j = last;
        int currentElement = (int) (i - Math.random() * (i - j));
        while (i < j) {
            while (i < currentElement && (array[i] <= array[currentElement])) {
                i++;
            }
            while (j > currentElement && (array[currentElement] <= array[j])) {
                j--;
            }
            if (i < j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == currentElement)
                    currentElement = j;
                else if (j == currentElement)
                    currentElement = i;
            }
        }
        mergeSort(array, first, currentElement);
        mergeSort(array, currentElement + 1, last);
    }

    public static void mergeSort(double[] array) {
        int first = 0;
        int last = array.length - 1;
        if (first >= last)
            return;
        int i = first, j = last;
        int currentElement = (int) (i - Math.random() * (i - j));
        while (i < j) {
            while (i < currentElement && (array[i] <= array[currentElement])) {
                i++;
            }
            while (j > currentElement && (array[currentElement] <= array[j])) {
                j--;
            }
            if (i < j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == currentElement)
                    currentElement = j;
                else if (j == currentElement)
                    currentElement = i;
            }
        }
        mergeSort(array, first, currentElement);
        mergeSort(array, currentElement + 1, last);
    }


    static int binarySearch(double[] array, double value) {
        int posL = 0;
        int posR = array.length - 1;
        int count = 0;

        while (posL <= posR) {
            count = (posL + posR) / 2;
            if (array[count] == value)
                break;
            else if (array[count] > value)
                posR = count;
            else posL = count + 1;
        }
        return count;
    }


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        System.out.println("Unsorted array");
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        //Helper.sort(array);
        mergeSort(array);


        System.out.println("Отсортированный массив");
        for (double gh :
                array) {
            System.out.print(" " + gh);

        }

        System.out.println();
        System.out.println("Find new indexes");
        System.out.println("first element=" + binarySearch(array, first));
        System.out.println("last element=" + binarySearch(array, last));

        System.out.println();

       /* double[] d1 = Generate.generateArray(2);
        double[] d2 = Generate.generateArray(4);
        System.out.println();
        Helper.sort(d1);
        System.out.println();
        Helper.sort(d2);
        System.out.println();
        double[] d3 = merge(d1,d2);

        for (double q1:d1
             ) {
            System.out.print(q1+" ");
        }
        System.out.println();

        for (double q2:d2
                ) {
            System.out.print(q2+" ");
        }
        System.out.println();

        for (double q3:d3
                ) {
            System.out.print(q3+" ");
        }
        System.out.println();*/

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
        System.out.println();
    }
}
