package by.it.kovko.jd01_03;

public class InOut {
    /**
     * Parsing string to an array
     * @param line String with array in it
     * @return Array that comprise of these elements
     */
    static double[ ] getArray(String line){
        String strings[];
        strings=line.trim().split(" ");
        double mas[]=new double [strings.length];
        for (int i=0; i<mas.length;++i)
            mas[i]=Double.parseDouble(strings[i]);
        return mas;
    }

    /**
     * Outputting of an array
     * @param arr Input array
     */
    static void printArray(double[ ] arr){
        for (double x: arr)
            System.out.print(x + " ");
        System.out.println();
    }

    /**
     * Printing an array with modifications
     * @param arr Input array
     * @param name Additional string
     * @param columnCount Number of columns
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i=0;i<arr.length;++i){
            System.out.printf(" %s [%-3.2f]",name, arr[i]);
            //System.out.print(name + " "+ arr[i]);
            if ((i+1)%columnCount==0 || i==arr.length-1)
                System.out.println();
        }
    }
}

