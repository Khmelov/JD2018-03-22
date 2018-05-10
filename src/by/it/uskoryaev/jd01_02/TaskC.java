package by.it.uskoryaev.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] [] mas = new int[n][n];

        step1(n);
        step2(mas);
        step3(mas);


    }
    private static int[ ][ ] step1(int n) {
        boolean max = false;
        boolean min = false;
        int [][] mas = new int[n][n];
        do {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (mas[i][j] == -n) min = true;
                    if (mas[i][j] == n) max = true;
                }
            }
        } while (!max && !min);
        for (int[] ma : mas) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(ma[j] + " ");
            }
            System.out.println();
        }
        return mas;
    }

    private static int step2(int[][] mas){
        return 0;
    }

   private static int[ ][ ] step3(int[ ][ ] mas){
return null;
    }

}
