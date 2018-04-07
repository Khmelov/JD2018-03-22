package by.it.shvedov.jd01_03;



import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line= scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
       double v[] = InOut.getArray(line);
       System.out.println("Максимум массива Max="+Helper.findMax(v));
       System.out.println("Миниммум массива Min="+Helper.findMin(v) );
       Helper.sort(v,false);
        InOut.printArray(v,"V",3);
    }
}
