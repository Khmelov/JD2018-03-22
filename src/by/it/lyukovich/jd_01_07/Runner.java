package by.it.lyukovich.jd_01_07;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Double[] arr = {1.0,2.0,4.0};
        AbstractVar r =new Scalar(3.1415);
        AbstractVar o = new Scalar(100);
        AbstractVar s1= new Scalar("12345");

        //
        Scalar s2= new Scalar((Scalar)s1);
        System.out.println(r);
        System.out.println(o);
        System.out.println(s1);
        System.out.println(s2);
        /*
        Вектора
        */
        double par[] = {1.,2.,4.};
        Vector v1 = new Vector(par);
        Vector v2 = new Vector(v1);
        Vector v3 = new Vector(v2.toString());
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        /*Матрицы*/
        AbstractVar m1 = new Matrix(new double[][]{{1.0,2.0,3.0},{3.0,4.0,5.0}});
        AbstractVar m2 = new Matrix((Matrix) m1);
        AbstractVar m3 = new Matrix(m1.toString());
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

    }
}
