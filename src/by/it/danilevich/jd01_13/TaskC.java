package by.it.danilevich.jd01_13;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TaskC {
    private static String inputNumber;
    private static int countErrors;
    private static List<Double> numbers;
    public static void main(String[] args) throws InterruptedException {

        numbers = new ArrayList<>();

        countErrors = 0;
        Scanner sc = new Scanner(System.in);

        while (countErrors < 5) {
            inputNumber = sc.next();
            readData();
        }
    }


    private static void readData() throws InterruptedException {
        double rez;
        try {
            rez = Double.parseDouble(inputNumber);
            numbers.add(rez);

        } catch (NumberFormatException | NullPointerException | ArithmeticException ex) {
            countErrors ++;
            if (countErrors==5) { throw new ArithmeticException();
              }
            else {
                Thread.sleep(100);
                for (int i=numbers.size()-1; i >=0; i--) {
                    System.out.print(numbers.get(i) + " ");
                  }
                System.out.println();
           }

        }
    }


}