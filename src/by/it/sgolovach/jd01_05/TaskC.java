package by.it.sgolovach.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double[] arrA = new double[37];
        step1(arrA);
        int[] arrayA = new int[31];
        step2(arrayA);
    }

    private static void step1(double[] arrA) {
        double j = 5.4;
        int sum = 0;
        double compos = 1.0;
        for (int i = 0; i < arrA.length; i++) {
            if (i == 0) arrA[i] = pow((5.33 * 5.33 + 4.5), 1.0 / 3);
            else if (i == arrA.length - 1) arrA[i] = pow((9.0 * 9.0 + 4.5), 1.0 / 3);
            else {
                arrA[i] = pow((j * j + 4.5), 1.0 / 3);
                j = j + 0.1;
            }
        }
        System.out.println("Массив A[]");
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] > 3.5) sum++;
            System.out.printf("A[ %d ] = %-10.5f", i, arrA[i]);
            if ((0 == (i + 1) % 5) || (arrA.length == i + 1))
                System.out.println();
        }
        double[] arrB = new double[sum];
        sum = 0;

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] > 3.5) {
                arrB[sum] = arrA[i];
                compos = compos * arrA[i];
                sum++;
            }
        }
        System.out.println("\nМассив B[] из элементов массива A > 3.5");
        for (int i = 0; i < arrB.length; i++) {
            System.out.printf("B[ %d ] = %-10.5f", i, arrB[i]);
            if ((0 == (i + 1) % 5) || (arrA.length == i + 1))
                System.out.println();
        }
        System.out.println("\nСреднее геометрическое значений массива B = " + pow(compos, 1.0 / arrB.length));
    }

    private static void step2(int[] arrayA) {
        int b = 0, c = 0;
        for (int i = 0; i < arrayA.length; i++) {
            int a = (int) (103 + Math.random() * 347);
            if ((double) a * 0.1 > i) b++;
            arrayA[i] = a;
        }

        double[] arrayB = new double[b];

        for (int i = 0; i < arrayA.length; i++) {
            if ((double) arrayA[i] * 0.1 > i) {
                arrayB[c] = (double) arrayA[i] * 0.1;
                c++;
            }
        }

        mergeSort(arrayB);

        printArray(arrayA, "A");
        System.out.println();
        printArray(arrayB, "B");
    }

    static void mergeSort(double[] array) {
        System.arraycopy(mergeSort(array, 0, array.length - 1), 0, array, 0, array.length);
    }


    private static double[] mergeSort(double[] array, int left, int right) {
        int a = right - left + 1;

        if (a == 1) return new double[]{array[left]};
        if (a == 2) {
            if (array[left] < array[right]) return new double[]{array[left], array[right]};
            return new double[]{array[right], array[left]};
        }

        int mid = (right - left + 1) / 2;

        double[] part1 = mergeSort(array, left, left + mid - 1);
        double[] part2 = mergeSort(array, left + mid, right);

        return merge(part1, part2);
    }


    private static double[] merge(double[] part1, double[] part2) {
        double[] arr = new double[part1.length + part2.length];
        int a = 0, b = 0;
        int k = part1.length + part2.length;
        for (int i = 0; i < k; i++) {
            if (b < part2.length && a < part1.length) {
                if (part1[a] > part2[b]) arr[i] = part2[b++];
                else arr[i] = part1[a++];
            } else if (b < part2.length) {
                arr[i] = part2[b++];
            } else {
                arr[i] = part1[a++];
            }
        }
        return arr;
    }


    static void printArray(int[] arr, String name) {
        char ch1 = 9556, ch2 = 9552, ch3 = 9574, ch4 = 9559, ch5 = 9553, ch6 = 9568, ch7 = 9580, ch8 = 9571, ch9 = 9562, ch10 = 9577, ch11 = 9565;
        int a;
        if (arr.length % 5 == 0) {
            a = arr.length / 5 * 2 + 1;
        } else a = (arr.length / 5 + 1) * 2 + 1;
        int ara = 0;
        for (int i = 0; i < a; i++) {
            if (i == 0) {
                System.out.print(ch1);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        for (int k = 0; k < 13; k++) {
                            System.out.print(ch2);
                        }
                    } else {
                        System.out.print(ch3);
                    }
                }
                System.out.print(ch4);
            }
            if (i == a - 1) {
                System.out.print(ch9);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        for (int k = 0; k < 13; k++) {
                            System.out.print(ch2);
                        }
                    } else {
                        System.out.print(ch10);
                    }
                }
                System.out.print(ch11);
            }

            if (i % 2 == 0 && i != 0 && i != a - 1) {
                System.out.print(ch6);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        for (int k = 0; k < 13; k++) {
                            System.out.print(ch2);
                        }
                    } else {
                        System.out.print(ch7);
                    }
                }
                System.out.print(ch8);
            }
            if (i % 2 != 0) {
                System.out.print(ch5);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        if (ara < arr.length) {
                            System.out.printf(" %s[%-2d]=%-2d ", name, ara, arr[ara]);
                            ara++;
                        } else {
                            for (int k = 0; k < 11; k++) {
                                System.out.print(" ");
                            }

                        }
                    } else {
                        System.out.print(ch5);
                    }
                }
                System.out.print(ch5);

            }
            System.out.println();
        }
    }


    static void printArray(double[] arr, String name) {
        char ch1 = 9556, ch2 = 9552, ch3 = 9574, ch4 = 9559, ch5 = 9553, ch6 = 9568, ch7 = 9580, ch8 = 9571, ch9 = 9562, ch10 = 9577, ch11 = 9565;
        int a;
        if (arr.length % 5 == 0) {
            a = arr.length / 5 * 2 + 1;
        } else a = (arr.length / 5 + 1) * 2 + 1;
        int ara = 0;
        for (int i = 0; i < a; i++) {
            if (i == 0) {
                System.out.print(ch1);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        for (int k = 0; k < 13; k++) {
                            System.out.print(ch2);
                        }
                    } else {
                        System.out.print(ch3);
                    }
                }
                System.out.print(ch4);
            }
            if (i == a - 1) {
                System.out.print(ch9);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        for (int k = 0; k < 13; k++) {
                            System.out.print(ch2);
                        }
                    } else {
                        System.out.print(ch10);
                    }
                }
                System.out.print(ch11);
            }

            if (i % 2 == 0 && i != 0 && i != a - 1) {
                System.out.print(ch6);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        for (int k = 0; k < 13; k++) {
                            System.out.print(ch2);
                        }
                    } else {
                        System.out.print(ch7);
                    }
                }
                System.out.print(ch8);
            }
            if (i % 2 != 0) {
                System.out.print(ch5);
                for (int j = 0; j < 9; j++) {
                    if (j % 2 == 0) {
                        if (ara < arr.length) {
                            System.out.printf("%s[%-2d]=%-2.1f ", name, ara, arr[ara]);
                            ara++;
                        } else {
                            for (int k = 0; k < 11; k++) {
                                System.out.print(" ");
                            }

                        }
                    } else {
                        System.out.print(ch5);
                    }
                }
                System.out.print(ch5);
            }
            System.out.println();
        }
    }

}
