package by.it.danilevich.jd01_04;
import java.util.Scanner;

public class InOut {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        double[] arr = getArray(line);
        printArray(arr);
        printArray(arr, "v", 5);

    }
    static double[ ] getArray(String line){
     String[] arrStr = line.split(" ");
     double[] arr = new double[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Double.parseDouble(arrStr[i]);
        }
     return arr;
    }
    static int[ ] getArrayToInt(String line){
        String[] arrStr = line.split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        return arr;
    }


    private static void printArray(double[ ] arr){
        for (double elem : arr ) {
            System.out.print(elem + " ");
          }
          System.out.println();
      }
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i< arr.length; i++ ) {
            System.out.printf("%s[% -3d]=%-10.4f",name,i,arr[i]);
            if ((i+1)%columnCount==0) System.out.println();
        }
        System.out.println();
    }

}
