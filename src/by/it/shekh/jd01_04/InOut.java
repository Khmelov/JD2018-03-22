package by.it.shekh.jd01_04;

class InOut {
    static double[] getArray(String line) {
        String[] strMas = line.trim().split(" ");
        double[] mas = new double[strMas.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(strMas[i]);
        }
        return mas;
    }

    static void printArray(double[] arr) {
        for (double el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i=0;i<arr.length;i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name,i, arr[i]);
            if((i+1)%columnCount==0 || (i+1)==arr.length) System.out.println();
        }
    }
}
