package by.it.kovko.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }




    private static void buildOneDimArray(String line){
        double arr[] = InOut.getArray(line);
        double first=arr[0], last=arr[arr.length-1];
        System.out.println("First=" + first + " Last=" + last);
        System.out.println("Unsorted array");
        String name="V"; int cols=5;
        InOut.printArray(arr,name, cols);
        mergeSort(arr);
        System.out.println("Sorted array");
        cols=4;
        InOut.printArray(arr,name, cols);

        int newFirstIndex, newLastIndex;
        newFirstIndex=binarySearch(arr,first);
        newLastIndex=binarySearch(arr,last);
        System.out.println("Index of first element=" + newFirstIndex);
        System.out.println("Index of last element=" + newLastIndex);
    }

    private static int binarySearch(double arr[],double k){
        int start=0, end=arr.length-1;
        int midPoint;
        while (true) {
            midPoint = (start + end) >>> 1;
            if (arr[midPoint] == k)
                return midPoint;
            else if (start == end)
                return -1;
            else if (arr[midPoint] < k)
                start = midPoint + 1;
            else if (arr[midPoint] > k)
                end = midPoint - 1;
        }
    }


    private static void mergeSort(double[ ] array){
        double result[];
        result=mergeSorting(array);
        System.arraycopy(result,0,array,0,array.length);
    }

    private static double[ ] mergeSorting(double[ ] array){
        int midPoint = array.length/2;
        if (array.length!=1){
            double part1[] = new double[midPoint];
            System.arraycopy(array,0,part1,0,midPoint);

            double part2[] = new double[array.length-midPoint];
            System.arraycopy(array,midPoint,part2,0,array.length-midPoint);
            array=merge(mergeSorting(part1),mergeSorting(part2));
        }
        return array;
    }

    private static double[ ] merge(double[ ] part1, double[ ] part2){
        double result[] = new double [part1.length+part2.length];
        int part1Index=0, part2Index=0;
        for (int i = 0; i < result.length; i++)
            result[i]=(part1Index<part1.length && (part2Index==part2.length || part1[part1Index]<part2[part2Index]))?part1[part1Index++]:part2[part2Index++];
        return result;
    }

}
