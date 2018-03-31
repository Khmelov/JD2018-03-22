package by.it.shekh.jd01_03;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();

        double[] myArr=InOut.getArray(line);
        InOut.printArray(myArr);
        InOut.printArray(myArr,"Mas",3);
        System.out.println("Maximum is:"+Helper.findMax(myArr));
        Helper.sort(myArr);
        InOut.printArray(myArr,"Mas",3);
    }

}


