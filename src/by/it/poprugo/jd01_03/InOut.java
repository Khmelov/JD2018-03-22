package by.it.poprugo.jd01_03;

class InOut {
    static double[] getArray(String line) { //return array of double
        // 1 2 3 4.5
        String[] strArr = line.trim().split(" "); /* убрали пробелы в начале
        и в конце (trim), разбили на строки, разделённые пробелом,
         занесли в массив строк strArr */
        double[] res = new double[strArr.length]; //in "res" - now "0"
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]); //string into double
        }
        return res;
    }
    static void printArray(double[] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount) {
        //v[ 0 ]=1.23344 v[ 1 ]=1.23344 v[ 2 ]=1.23344
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,arr[i]); //souf - magic
            if (((i+1)%columnCount==0) || ((i+1)==arr.length)) //чтобы перевод строки - после её выведения
                System.out.println();
        }
    }
}
