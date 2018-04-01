package by.it.sgolovach.jd01_03;

public class InOut {


    static double[] getArray(String line) {
        line = line.trim();
        String[] elemString = line.split(" ");
        double[] mas = new double[elemString.length];

        for (int i = 0; i < elemString.length; i++) {
            mas[i] = Double.parseDouble(elemString[i]);
        }
        return mas;
    }


    static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((0 == (i + 1) % columnCount) || (arr.length == i + 1))
                System.out.println();

        }
    }
}
