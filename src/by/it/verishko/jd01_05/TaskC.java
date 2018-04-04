package by.it.verishko.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double x = 5.33; x <= 9; x = x + 0.1) {
            double z = pow((pow(x, 2) + 4.5), 1.0 / 3);
        }
    }

    private static void step2() {
        int[] arr = new int[31];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 348 + 103);
        }
    }
}
