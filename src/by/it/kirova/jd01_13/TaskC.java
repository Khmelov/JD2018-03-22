package by.it.kirova.jd01_13;

import java.util.*;

public class TaskC {
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }


    private static void readData() throws InterruptedException {
        List<Double> list = new ArrayList<>();
        int count = 0;
        while (true){
            try {
                String str = scanner.nextLine();
                double num = Double.parseDouble(str);
                list.add(num);
            } catch (NullPointerException | NumberFormatException e) {
                count++;
                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
                if (count == 5) {
                    throw e;
                }
            }
        }

    }


}