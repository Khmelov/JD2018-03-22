package by.it.danilevich.jd01_04;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);

    }
    private static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                int rez = i*j;
                System.out.printf("%d*%d=%-4d",i,j,rez);
            }
            System.out.println();
        }

    }
    private static void buildOneDimArray(String line){
        double[] mas = InOut.getArray(line);
        double firstElem = mas[0];
        double lastElem = mas[mas.length-1];
        InOut.printArray(mas,"V",5);
        mas = Helper.sort(mas);//сортировку переделать по другому!

        InOut.printArray(mas,"V",4);
        int i1 = Helper.findIndexElementa(mas, firstElem);
        int i2 = Helper.findIndexElementa(mas, lastElem);
        System.out.println("Index of first element= " + i1);
        System.out.println("Index of last element= " + i2);

    }


    //сортировка слиянием
   /*  static void mergeSort(double[ ] array){


    }
   private static double[ ] mergeSort(double[ ] array, int left, int right){
        double newMas[] = new double[array.length];
                return newMas;
    }
    private static double[ ] merge(double[ ] part1, double[ ] part2){
        double newMas[] = new double[part1.length + part2.length];
        return newMas;

    }*/

    /*static int binarySearch(double[ ] array, double value){

        int findIndex = 0;
        return findIndex;


    }*/

}
