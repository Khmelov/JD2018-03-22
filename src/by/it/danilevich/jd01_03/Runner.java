package by.it.danilevich.jd01_03;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Введите строку из одномерных массивов: ");
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        double[] arr = InOut.getArray(s);
        arr = Helper.sort(arr);
        double min = Helper.findMin(arr);
        System.out.println("Minimum = " + min);

        double max = Helper.findMax(arr);
        System.out.println("Maximum = " + max);


    }
}
