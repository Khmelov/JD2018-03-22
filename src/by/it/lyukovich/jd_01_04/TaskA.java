package by.it.lyukovich.jd_01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
    printMulTable();
    Scanner scan=new Scanner(System.in);
    String s = scan.nextLine();
    buildOneDimArray(s);
    }
    private static void printMulTable(){
        int[] nArray;
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i*j);

            }
            System.out.println();
        }

    }
    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length-1];
        InOut.printArray(array,"V",5);
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start){
                System.out.println("Index of first element="+i);
                break;
            }
            
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == stop){
                System.out.println("Index of last element="+i);
                break;
            }

        }

    }

}
