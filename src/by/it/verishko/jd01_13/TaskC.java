package by.it.verishko.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner sc;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        readData();
    }

    private static void readData() throws InterruptedException {
        List<Double> list = new ArrayList<>();
//        String string;
        int count = 0;
//        while (!(string = sc.nextLine()).equals(Number))
        try {
//            String str = sc.nextLine();
            list.add(Double.parseDouble(sc.nextLine()));
        } catch (NullPointerException | NumberFormatException e) {
            count++;
            Thread.sleep(100);
            System.out.println("ERROR: " + count);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            if (count == 5) {
                throw e;
            }
        }
    }
}
