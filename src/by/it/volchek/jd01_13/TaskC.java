package by.it.volchek.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by volchek on 19.04.18.
 */
public class TaskC {
    static ArrayList<Double> numbers = new ArrayList<>();
    static int errorCount=0;
    static Scanner scanner;
    static void readData() throws InterruptedException {
            try {
                numbers.add(Double.parseDouble(scanner.nextLine()));
            }
            catch (NumberFormatException e){
                errorCount++;
                if (errorCount>5) throw new NumberFormatException();
                Thread.sleep(100);
                System.out.println("ERROR! #"+errorCount);
                for (int i = 0; i < numbers.size() ; i++) {
                    System.out.print(numbers.get(numbers.size()-i-1)+" ");
                }
                System.out.println();
            }

    }

    public static void main(String[] args) throws InterruptedException,NumberFormatException {
        scanner=new Scanner(System.in);
        String str;
        for (;;){
            readData();
        }

    }
}
