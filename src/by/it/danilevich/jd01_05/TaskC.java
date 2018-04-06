package by.it.danilevich.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        int kolelem = 28;
        double nach = 5.33;
        double kon = 9;
        double[] arr = new double[kolelem];
        int i =0;
        int columnCount = 5;
        int kol35 = 0;
        //посчитаем  шаг
        double shag = (kon - nach)/kolelem;
        for (double x = nach; x <=kon ; x = x + shag) {
            double z = Math.cbrt(x*x + 4.5);
            arr[i] = z;
            i = i + 1;
            if (z > 3.5) kol35 = kol35 +1;
        }
        i=0;
        double[] mas35 = new double[kol35];
        for (int j = 0; j< arr.length; j++ ) {
            System.out.printf("%s[% -3d]=%-10.4f","A",j,arr[j]);
            if ((j+1)%columnCount==0) System.out.println();
            if (arr[j] > 3.5){
                mas35[i] = arr[j];
                i= i +1;
            }
        }
        System.out.println();
        double sum =0;
        double sredn =0;
        System.out.println("Новый массив с элементами > 3.5");
        for (int j = 0; j< mas35.length; j++ ) {
            System.out.printf("%s[% -3d]=%-10.4f","B",j,mas35[j]);
            if ((j+1)%columnCount==0) System.out.println();
            sum = sum + mas35[j];
          }
        System.out.println();
          sredn = sum/mas35.length;
        System.out.println(" Среднее арифметическое = " + sredn);
        System.out.println();

    }
}
