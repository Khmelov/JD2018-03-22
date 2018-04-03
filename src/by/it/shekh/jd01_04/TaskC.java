package by.it.shekh.jd01_04;

import java.util.Scanner;

public class TaskC {

    private static void buildOneDimArray(String line) {
        double[] mas = InOut.getArray(line);
        double first = mas[0];
        double last = mas[mas.length - 1];
        InOut.printArray(mas);
        mergeSort(mas);
        InOut.printArray(mas);

        System.out.println("V[1]=" + mas[0] + " first item=" + binarySearch(mas, first));
        System.out.println("V[" + mas.length + "]=" + mas[mas.length - 1] + " last item=" + binarySearch(mas, last));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    private static void mergeSort(double[] array) {
        System.arraycopy(mergeSort(array, 0, array.length - 1), 0, array, 0, array.length);//копирует массивы
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        //выход из рекурсии
        int chck = right - left + 1;//количество элементов в разбитом массиве

        if (chck == 1) return new double[]{array[left]};
        if (chck == 2) {
            if (array[left] > array[right])
                return new double[]{array[right], array[left]};
            return new double[]{array[left], array[right]};
        }


        int m = (right - left + 1) / 2;//находим середину массива
        double[] part1 = mergeSort(array, left, left + m - 1);
        double[] part2 = mergeSort(array, left + m, right);

        return merge(part1, part2);


    }

    private static double[] merge(double[] part1, double[] part2) {
        int len1 = part1.length, len2 = part2.length;
        int len = len1 + len2, a = 0, b = 0;//a,b-счетчики в каждом из массивов


        double res[] = new double[len];

        for (int i = 0; i < len; i++) {
            if (b < len2 && a < len1) {
                if (part1[a] > part2[b]) res[i] = part2[b++];
                else res[i] = part1[a++];
            } else if (b < len2)
                res[i] = part2[b++];
            else res[i] = part1[a++];
        }
        return res;
    }

    private static int binarySearch(double[] array, double value) {
        int l = 0, r = array.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (array[m] == value) return m;
            else if (array[m] > value) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
}