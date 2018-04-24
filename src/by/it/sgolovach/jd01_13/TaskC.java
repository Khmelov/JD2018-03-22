package by.it.sgolovach.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC extends Exception{

    private static void readData() throws Exception {
        int sum = 0;
        List<Double> array = new ArrayList<>();
        String line;
        while (sum >= 0) {
            line = scaner.nextLine();
            try {
                double b = Double.parseDouble(line);
                array.add(b);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                sum++;
                for (int i = array.size()-1; i >= 0; i--) {
                    System.out.print(array.get(i) + " ");
                }
                if(sum==5) throw new Exception();
            }
        }
    }

    private static Scanner scaner;

    public static void main(String[] args) throws Exception {
        scaner = new Scanner(System.in);
        readData();
    }
}
