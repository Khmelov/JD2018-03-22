package by.it.uskoryaev.jd01_04;

import java.util.Scanner;

public class TaskA {
    static void printMulTable(){
        for (int i = 2; i <=9 ; i++) {
            for (int j = 2; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-3d",i,j,j*i);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){
        double [] array = InOut.getArray(line);
        System.out.println("unsorted array");
        InOut.printArray(array);
        double first = array[0];
        double last = array[array.length-1];
        System.out.println("sorted array");
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        System.out.println("find new index");
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == first){
                System.out.println("first element="+i);
                break;
            }
        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == last){
                System.out.println("last element="+i);
                break;
            }
        }
    }
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
}
