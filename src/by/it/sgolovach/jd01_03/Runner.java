package by.it.sgolovach.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String line = scaner.nextLine();

        double[] mas = InOut.getArray(line);
        InOut.printArray(mas);
        InOut.printArray(mas, "V", 3);


        System.out.println(Helper.findMin(mas));
        System.out.println(Helper.findMax(mas));
        Helper.sort(mas);


    }
}
