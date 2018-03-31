package by.it.kovko.jd01_04;


import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
//        TaskA.printMulTable();
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        buildOneDimArray(line);


        double p1[]={3,6,2,1,5,9,7,8};


        //mergeSort(p1);
        //Helper.sort(p1); Helper.sort(p2);
//        System.out.println(Arrays.toString(p1));
//        System.out.println(Arrays.toString(p2));
        //System.out.println(Arrays.toString(merge(pp1,pp2)));
        //double p12[] = merge(p1,p2);
        //System.out.println(Arrays.toString(p1));
        //System.out.println(binarySearch(p1,p1[3]));
//        System.out.println("\n\n\n" + Arrays.toString(kkk));

        //System.out.println(Arrays.toString(merge(p1,p2)));
    }




    static void buildOneDimArray(String line){
        double arr[] = InOut.getArray(line);
        double first=arr[0], last=arr[arr.length-1];
        System.out.println("First=" + first + " Last=" + last);
        System.out.println("Unsorted array");
        InOut.printArray(arr,"V", 5);
        by.it.kovko.jd01_04.Helper.sort(arr);
        System.out.println("Sorted array");
        InOut.printArray(arr,"V", 4);
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i]==first){
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i]==last){
                System.out.println("Index of last element=" + i);
                break;
            }


        }

    }

    static int binarySearch(double arr[],double k){
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


    static void mergeSort(double[ ] array){
        double result[]= new double[array.length];
        result=mergeSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++)
            array[i]=result[i];
    }

    private static double[ ] mergeSort(double[ ] array, int left, int right){
        int midPoint = array.length/2;
        if (array.length!=1){
            double part1[] = new double[midPoint];
            for (int i = 0; i < midPoint; i++)
                part1[i]=array[i];

            double part2[] = new double[array.length-midPoint];
            for (int i = midPoint; i < array.length; i++)
                part2[i-midPoint]=array[i];
            array=merge(mergeSort(part1,3,3),mergeSort(part2,3,3));
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
