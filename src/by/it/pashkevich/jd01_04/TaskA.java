package by.it.pashkevich.jd01_04;

import java.util.Scanner;

public class TaskA {
    static void printMulTable (){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        System.out.println("unSorted array");
        InOut.printArray(array, "V", 5);
        System.out.println("Sorted array");
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        System.out.println("Find new indexes");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
    public static void main(String[] args){
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }
}
