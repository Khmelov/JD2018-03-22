package by.it.kovko.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        TaskA.printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
    private static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line){
        double arr[] = InOut.getArray(line);
        double first=arr[0], last=arr[arr.length-1];
        System.out.println("First=" + first + " Last=" + last);
        System.out.println("Unsorted array");
        String name="V"; int cols=5;
        InOut.printArray(arr,name, cols);
        by.it.kovko.jd01_03.Helper.sort(arr);
        System.out.println("Sorted array");
        cols=4;
        InOut.printArray(arr,name, cols);
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


}
