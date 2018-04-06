package by.it.volchek.jd01_07;

/**
 * Created by volchek on 05.04.18.
 */
public class Runner {
    public static void main(String[] args) {

        Vector v1 = new Vector("{1,2,3.0}");
        Vector v2 = new Vector("{1.3,3.2}");
        Vector v3 = new Vector(v1);
        double[] z = {1,2,4.5};
        Vector v4 = new Vector(z);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        double[][] x = {{2.0,4.5},{2.3,4.9},{4.3,4.4}};
        Matrix m1 = new Matrix(x);
        Matrix m3 = new Matrix("{{2.3,2.3},{2.4,3.5},{99.8,76.5},{2,4}}");
        Matrix m2 = new Matrix(m3);

        System.out.println(m3);
        System.out.println(m2);
        System.out.println(m1);




    }
}
