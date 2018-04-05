package by.it.shvedov.jd01_05;
import static java.lang.Math.*;
public class TaskC {
    public static void main(String[] args) {

        step1();
    }

    public static void step1() {
        int columCount = 5;
        String name = "v";
        double z = 0;
        double[] mas = new double[30];
        for (int i = 0; i < mas.length; i++) {
            double x = (random() * 3.67) + 5.33;
            mas[i] = cbrt(x * x - 4.5);

        }
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f", name, i, mas[i]);
            if ((i + 1) % columCount == 0 || i + 1 == mas.length)
                System.out.println();
        }
        //for(int i=0; i<mas.length; i++) {
        //if (mas[i] < 3.5) break;
        //}
        //for(int j=i; j<mas.length; j++){
        //int k=0;
        // mas[j]=mas[j+1];
        // mas.length=k;
        // k--;
        // System.out.println(mas[i]);
        // }


    }
    }

