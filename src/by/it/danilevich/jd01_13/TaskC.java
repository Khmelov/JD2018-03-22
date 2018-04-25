package by.it.danilevich.jd01_13;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TaskC {
    private static Scanner sc;
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        readData();
    }

    private static void readData() throws InterruptedException {
        double rez;
        List<Double> numbers = new ArrayList<>();
        int countErrors = 0;
        String inputNumber="";


        try {
            while (countErrors < 5) inputNumber = sc.next();

            rez = Double.parseDouble(inputNumber);
            numbers.add(rez);

        } catch (NumberFormatException | NullPointerException | ArithmeticException ex) {
            countErrors ++;
            Thread.sleep(100);
            for (int i=numbers.size()-1; i >=0; i--) {
                System.out.print(numbers.get(i) + " ");
            }
            System.out.println();
            if (countErrors==5) {
                throw ex;//new ArithmeticException();
              }


        }
    }


}