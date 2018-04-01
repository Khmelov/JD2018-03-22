package by.it.uskoryaev.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] mas = new int[10];
        for (int incWriteMas = 0; incWriteMas < mas.length; incWriteMas++) {
            mas [incWriteMas] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }


    private static void step1(int[] mas){
            int min = mas[0];
            int max = mas[0];
        for (int elementMas : mas) {
            if (min > elementMas) min = elementMas;
            if (max < elementMas) max = elementMas;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas){
        double srSym = 0;
        for (int elementMas : mas){
            srSym = srSym + elementMas;
        }
        srSym = srSym/mas.length;
        for (int elementMas : mas){
            if (srSym > elementMas) System.out.print(elementMas + " ");
        }
        }
    private static void step3(int [] mas){
        int min = mas[0];
        for (int elementMas : mas) {
            if (min > elementMas) min = elementMas;
        }
        for (int elementMas = mas.length-1; elementMas >= 0; elementMas--) {
            if (mas[elementMas] == min) {
                System.out.print(elementMas + " ");
            }
        }
    }
}
