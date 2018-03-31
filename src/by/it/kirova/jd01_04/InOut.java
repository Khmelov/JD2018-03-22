package by.it.kirova.jd01_04;

public class InOut {


    /**
     * Преобразование строки в одномерный массив со значениями типа double
     *
     * @param line - строка со значениями
     * @return arr - одномерный массив со значениями типа double
     */
    static double[] getArray(String line) {
        String[] strArr = line.trim().split(" ");
        int count = strArr.length;
        double[] arr = new double[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Double.parseDouble(strArr[i]);
        }
        System.out.println();
        return arr;
    }

    /**
     * Вывод на печать одномерного массива без форматирования
     *
     * @param arr - одномерный массив типа double
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + "  ");
        }
        System.out.println();
    }


    /**
     * Вывод на печать форматированного одномерного массива (вектора)
     * @param arr         - одномерный массив типа double
     * @param columnCount - количество выводимых столбцов до переноса строки
     * @param name        - имя элемента массива
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-3d]=%-8.2f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }
}