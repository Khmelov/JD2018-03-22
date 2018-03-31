package by.it.kovko.jd01_04;

public class InOut {
    static double[ ] getArray(String line){
        String strings[];
        strings=line.trim().split(" ");
        double mas[]=new double [strings.length];
        for (int i=0; i<mas.length;++i)
            mas[i]=Double.parseDouble(strings[i]);
        return mas;
    }
    static void printArray(double[ ] arr){
        for (double x: arr)
            System.out.print(x + " ");
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i=0;i<arr.length;++i){
            System.out.printf(" %s[%d]=%f.3",name, i, arr[i]);
            //System.out.print(name + " "+ arr[i]);
            if ((i+1)%columnCount==0 || i==arr.length-1)
                System.out.println();
        }
    }
}

