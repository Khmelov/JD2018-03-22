package by.it.shvedov.jd01_04;

public class InOut {
    static double[] getArray(String line){
        // 1 2 3 4 5
       String[] strArr= line.split(" ");
       double[] res=new double[strArr.length];
       for(int i=0; i<strArr.length; i++) {
           res[i] = Double.parseDouble(strArr[i]);
       }
        return res;
    }
    static void printArray(double [] res){
        for (double element : res){
            System.out.print(element+" ");
        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int columCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f", name, i, arr[i]);
            if ((i + 1) % columCount == 0 || i + 1 == arr.length)
                System.out.println();


        }
    }
}

