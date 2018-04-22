package by.it.volchek.jd01_03;

import java.util.Scanner;

/**
 * Created by volchek on 27.03.18.
 */
public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] mas = InOut.getArray(line);
        /*for (double i: mas) {
            System.out.print(" "+i);

        }*/
        InOut.printArray(mas);
        InOut.printArray(mas, "v", 5);
        System.out.println(Helper.findMax(mas));
        System.out.println(Helper.findMin(mas));
        Helper.sort(mas);
        Generate.generateArray(5);
        Generate.generateArray(4, 7);
        Helper.mul(Generate.generateArray(3, 5), Generate.generateArray(5, 6));
    }

}
