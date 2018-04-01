package by.it.kirova.jd01_05;


import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        step1();
        System.out.println("Задание 2");
        step2();
    }


    private static void step1() {
        System.out.println("Массив А[]");
        int col = 5;
        int count = (int) ((9 - 5.33) / 0.1 + 1);
        double[] array = new double[count];
        int i = 0;
        for (double x = 5.33; x <= 9; x = x + 0.1) {
            double z = pow((pow(x, 2) + 4.5), 1.0 / 3);
            array[i] = z;
            i++;
        }
        Printer.printArrayDouble(array, "A", col);
        System.out.println("Массив B[] из элементов массива A > 3.5");
        int k = 0;
        for (double element : array) {
            if (element > 3.5) {
                k++;
            }
        }
        double[] array2 = new double[k];
        k = 0;
        for (double element : array) {
            if (element > 3.5) {
                array2[k] = element;
                k++;
            }
        }
        Printer.printArrayDouble(array2, "B", col);
        double mul = 1;
        for (double element : array2) {
            mul = mul * element;
        }
        double gm = pow(mul, 1.0 / array2.length);
        System.out.println("Среднее геометрическое элементов массива B[]: " + gm);

    }


    private static void step2() {
        int[] a = new int[31];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 348 + 103);
        }
        System.out.println("Массив А[] с элементами в диапазоне [103; 450]");
        Printer.printArrayIntA(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] * 0.1 > i) {
                count++;
            }
        }
        int[] b = new int[count];
        count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] * 0.1 > i) {
                b[count] = a[i];
                count++;
            }
        }
        // printArrayInt(b);
        Helper.mergeSort(b);
        System.out.println("Отсортированный массив B[]");
        Printer.printArrayIntB(b);

    }


}




