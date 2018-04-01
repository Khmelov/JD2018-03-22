package by.it.kirova.jd01_05;

public class Printer {

    public static void printArrayDouble(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% 3d]=% -10.5f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }



    public static void printArrayIntA(int[] arr) {
        int columnCount = 5;
        int columnWidth = 13;
        String nn = "A";
        printCore(columnCount, columnWidth, "\u2554", "\u2566", "\u2557");
        int rowCount = (int) Math.ceil((double) arr.length / columnCount);
        for (int i = 0; i < rowCount - 1; i++) {
            printIndexToRow(columnCount, i, arr, nn);
            printCore(columnCount, columnWidth, "\u2560", "\u256C", "\u2563");
        }
        printIndexToRow(columnCount, rowCount - 1, arr, nn);
        printCore(columnCount, columnWidth, "\u255A", "\u2569", "\u255D");
    }

    private static void printIndexToRow(int columnCount, int rowIndex, int[] array, String name) {
        System.out.print("\u2551 ");
        for (int i = 0; i < columnCount; i++) {
            int j = columnCount * rowIndex + i;
            if (j > array.length - 1) {
                System.out.print("           ");
            } else {
                System.out.printf("%s[% -3d]=%-4d", name, j + 1, array[j]);
            }
            System.out.print(" \u2551 ");
        }
        System.out.println();
    }


    public static void printArrayIntB(int[] arr) {
        int columnCount = 4;
        int columnWidth = 13;
        String nn = "B";
        printCore(columnCount, columnWidth, "\u2554", "\u2566", "\u2557");
        int rowCount = (int) Math.ceil((double) arr.length / columnCount);
        for (int i = 0; i < rowCount - 1; i++) {
            printIndexToCol(columnCount, i, rowCount, arr, nn);
            printCore(columnCount, columnWidth, "\u2560", "\u256C", "\u2563");
        }
        printIndexToCol(columnCount, rowCount-1, rowCount, arr, nn);
        printCore(columnCount, columnWidth, "\u255A", "\u2569", "\u255D");
    }

    private static void printIndexToCol(int columnCount, int rowIndex, int rowCount, int[] array, String name) {
        System.out.print("\u2551 ");
        for (int i = 0; i < columnCount; i++) {
            int j = rowIndex + rowCount * i;
            if (j > array.length - 1) {
                System.out.print("           ");
            } else {
                System.out.printf("%s[% -3d]=%-4d", name, j + 1, array[j]);
            }
            System.out.print(" \u2551 ");
        }
        System.out.println();
    }


    private static void printLine(int width) {
        for (int j = 0; j < width; j++) {
            System.out.print("\u2550");
        }
    }

    private static void printCore(int column, int columnWidth, String left, String middle, String right) {
        System.out.print(left);
        for (int i = 0; i < column - 1; i++) {
            printLine(columnWidth);
            System.out.print(middle);
        }
        printLine(columnWidth);
        System.out.println(right);

    }


}

