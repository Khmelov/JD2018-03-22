package by.it.desykevich.jd01_03;


public class InOut {

        public static double[] getArray(String line) {

            String[] strArr = line.split(" "); //
            double[] res = new double[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                res[i] = Double.parseDouble(strArr[i]); //перевод сторк в число типа double
            }
            return res;
        }
        static void printArray(double[ ] arr)  {
            for (double element:arr){
                System.out.print(element+" "); //вывод эелменотм массима из строки в число
            }
            System.out.println();
        }
        public static void printArray(double[] arr, String name, int columnCount){
            for (int i = 0; i <arr.length ; i++) {
                System.out.printf("[%s[% -3d]=%-10.3f ",name,i,arr[i]);
                // если остаток от деления  на колличество колонок  оказался равен 0 или i+1 равен длине массива то переходи на след строку
                if (((i+1)%columnCount==0) || (i+1==arr.length))
                    System.out.println();
            }

        }

}
