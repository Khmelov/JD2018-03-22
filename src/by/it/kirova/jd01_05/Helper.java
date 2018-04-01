package by.it.kirova.jd01_05;

public class Helper {

     public static void mergeSort(int[] array) {
        int l = 0;
        int r = array.length - 1;
        int[] temp = mergeSort(array, l, r);
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }

    }


    private static int[] mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            int[] part1 = mergeSort(array, left, middle);
            int[] part2 = mergeSort(array, middle + 1, right);
            return merge(part1, part2);
        }
        int[] single = new int[1];
        single[0] = array[left];
        return single;
    }


    private static int[] merge(int[] part1, int[] part2) {
        int n1 = part1.length;
        int n2 = part2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] array = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (part1[i] <= part2[j]) {
                array[k] = part1[i];
                i++;
            } else {
                array[k] = part2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = part1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = part2[j];
            j++;
            k++;
        }
        return array;
    }


}
