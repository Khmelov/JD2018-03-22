package by.it.volchek.jd01_05;

/**
 * Created by volchek on 31.03.18.
 */

import static java.lang.Math.*;

import java.util.Arrays;

public class TaskC {
    static void task6() {
        int count = 0;
        for (double i = 5.33; i < 9; i += 0.1) {
            count++;
        }
        double[] mas = new double[count];
        double iter = 5.33;
        int pos = 0;
        int newArrayElemNumber = 0;
        System.out.println("Массив");
        for (double elem : mas) {
            elem = pow((iter * iter + 4.5), 1.0 / 3);
            mas[pos] = elem;
            iter += 0.1;
            System.out.printf("v[%2d] = %6.4f ", pos, elem);
            pos++;
            if (pos % 5 == 0) System.out.println();
            if (elem > 3.5) newArrayElemNumber++;
        }
        System.out.println();
        double[] newArray = new double[newArrayElemNumber];
        pos = 0;
        System.out.println("Новый массив");
        double mult = 1;
        for (double elem : mas) {
            if (elem > 3.5) {
                newArray[pos] = elem;
                System.out.printf("n[%2d] = %6.4f ", pos, newArray[pos]);
                mult *= newArray[pos];
                pos++;
                if (pos % 5 == 0) System.out.println();
            }
        }
        System.out.printf("\nСреднее геометрическое равно: %6.8f", pow(mult, 1.0 / (pos)));

    }

    static void task7() {
        int[] array = new int[31];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) round(103 + random() * (451 - 103));
        }
        int newArrayCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i * 10) newArrayCount++;
        }
        int[] newArray = new int[newArrayCount];
        int pos = 0;
        System.out.print("\u250c");
        for (int k = 0; k < 55; k++) {
            System.out.print("\u2500");
        }
        System.out.print("\u2510");
        System.out.println();
        System.out.println("│Массив А:                                              │");
        upperLine();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i * 10) {
                newArray[pos] = array[i];
                pos++;
            }
            if ((i % 30 == 0) && (i > 0))
                System.out.printf("││A[%2d]=%3d│                                            │", i, array[i]);
            else if (i % 5 == 0)
                System.out.printf("││A[%2d]=%3d│", i, array[i]);
            else if (i % 5 == 4) System.out.printf("│A[%2d]=%3d││", i, array[i]);
            else System.out.printf("│A[%2d]=%3d│", i, array[i]);
            if (i % 29 == 0 && i > 0) {
                System.out.println();
                downLine();
                System.out.print("\u2502");
                System.out.print("\u250c");
                for (int k = 0; k < 9; k++) {
                    System.out.print("\u2500");
                }
                System.out.print("\u2510                                            │");
                System.out.println();
                continue;
            }
            if (i % 30 == 0 && i > 0) {
                System.out.println();
                System.out.print("\u2502");
                System.out.print("\u2514");
                for (int k = 0; k < 9; k++) {
                    System.out.print("\u2500");
                }
                System.out.print("\u2518                                            │");
                break;
            }
            if (i % 5 == 4) {
                System.out.println();
                downLine();
                upperLine();
            }
            ;
        }


        System.out.println();
        Arrays.sort(newArray);
        System.out.println("│Массив B:                                              │");
        int flag = 0;
        int mod = newArray.length % 7;
        for (int j = 0; j < 7; j++) {
            flag++;
            if ((flag < mod + 1) || (newArray.length > 27)) upperLine4();
            else upperLine3();
            for (int i = 0; i < pos; i++) {
                if ((i < 7) && (i % 7 == j)) System.out.print("│");
                if (i % 7 == j)
                    System.out.printf("│B[%2d]=%3d│", i, newArray[i]);
            }
            if (newArray.length > 27) System.out.print("           │");
            else if (flag < mod + 1) System.out.print("           │");
            else if (flag >= mod + 1) System.out.print("                      │");
            System.out.println();
            if ((flag < mod + 1) || (newArray.length > 27)) downLine4();
            else downLine3();

        }
        System.out.print("\u2514");
        for (int k = 0; k < 55; k++) {
            System.out.print("\u2500");
        }
        System.out.print("\u2518");


    }

    static void upperLine() {
        System.out.print("│");
        for (int i = 0; i < 5; i++) {
            System.out.print("\u250c");
            for (int k = 0; k < 9; k++) {
                System.out.print("\u2500");
            }
            System.out.print("\u2510");
        }
        System.out.print("│");
        System.out.println();

    }

    static void upperLine3() {
        System.out.print("│");
        for (int i = 0; i < 3; i++) {
            System.out.print("\u250c");
            for (int k = 0; k < 9; k++) {
                System.out.print("\u2500");
            }
            System.out.print("\u2510");
        }
        System.out.print("                      │");
        System.out.println();

    }

    static void upperLine4() {
        System.out.print("│");
        for (int i = 0; i < 4; i++) {
            System.out.print("\u250c");
            for (int k = 0; k < 9; k++) {
                System.out.print("\u2500");
            }
            System.out.print("\u2510");
        }
        System.out.print("           │");
        System.out.println();

    }

    static void downLine() {
        System.out.print("│");
        for (int i = 0; i < 5; i++) {
            System.out.print("\u2514");
            for (int k = 0; k < 9; k++) {
                System.out.print("\u2500");
            }
            System.out.print("\u2518");
        }
        System.out.print("│");
        System.out.println();
    }

    static void downLine3() {
        System.out.print("│");
        for (int i = 0; i < 3; i++) {
            System.out.print("\u2514");
            for (int k = 0; k < 9; k++) {
                System.out.print("\u2500");
            }
            System.out.print("\u2518");
        }
        System.out.print("                      │");
        System.out.println();
    }

    static void downLine4() {
        System.out.print("│");
        for (int i = 0; i < 4; i++) {
            System.out.print("\u2514");
            for (int k = 0; k < 9; k++) {
                System.out.print("\u2500");
            }
            System.out.print("\u2518");
        }
        System.out.print("           │");
        System.out.println();
    }

    public static void main(String[] args) {
        task6();
        System.out.println();
        task7();


        /*System.out.println();
        System.out.print("\u2502");
        for (int i = 0; i <25 ; i++) {
            System.out.print(" ");
        }
*/


    }
}
