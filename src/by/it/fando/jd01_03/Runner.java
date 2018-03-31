package by.it.fando.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        double [] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);

        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);



    }

}
