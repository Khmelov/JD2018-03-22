package by.it.shekh.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        printMulTable();
        buildOneDimArray(line);

    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line) {

        String[] strMas = line.trim().split(" ");
        double[] mas = new double[strMas.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(strMas[i]);
        }


        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", "V", i, mas[i]);
            if ((i + 1) % 5 == 0 || (i + 1) == mas.length) System.out.println();
        }
        double first = mas[0];
        double last = mas[mas.length - 1];
        System.out.println();
        Arrays.sort(mas);
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", "V", i, mas[i]);
            if ((i + 1) % 4 == 0 || (i + 1) == mas.length) System.out.println();
        }
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
}
