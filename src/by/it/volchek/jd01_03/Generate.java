package by.it.volchek.jd01_03;

/**
 * Created by volchek on 27.03.18.
 */
public class Generate {
    static double[][] generateArray(int i, int j) {
        double[][] mas = new double[i][j];

        for (int m = 0; m < mas.length; m++) {
            for (int k = 0; k < mas[0].length; k++) {
                mas[m][k] = (-i - 1 + Math.random() * (i + 1) * 2);
            }
        }


        for (double element[] : mas) {
            for (double subElement : element) {
                System.out.print(subElement + " ");
            }
            System.out.println();

        }

        return mas;
    }

    static double[] generateArray(int i) {
        double[] mas = new double[i];

        for (int m = 0; m < mas.length; m++) {

            mas[m] = (-i - 1 + Math.random() * (i + 1) * 2);

        }


        for (double element : mas) {

            System.out.print(element + " ");
        }
        System.out.println();


        return mas;
    }

}


