package by.it.volchek.jd01_03;

/**
 * Created by volchek on 27.03.18.
 */
public class InOut {
    public static double[] getArray(String line) {
        String[] strArr = line.trim().split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    public static void printArray(double[] arr) {
        for (double i : arr) {
            System.out.print(i + " ");

        }
        System.out.println();
    }

    public static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -2d]=%-10.3f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0) System.out.println();

        }
        System.out.println();
    }


}
