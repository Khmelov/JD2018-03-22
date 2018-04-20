package by.it.danilevich.jd01_07;

public class Runner {

    public static void main(String[] args) {
        AbstractVar s = new Scalar(3.1415);
        AbstractVar s1 = new Scalar("123");
        Scalar s2 = new Scalar((Scalar) s1);
        //AbstractVar v = new Vector();
        //Object o = new Scalar(10);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
      //  System.out.println(v);
        System.out.println(0);

        Vector v = new Vector("1,2,4");
        Vector v2 = new Vector(v);
        double[] arr2= new double[]{5,6,8};
        Vector v3 = new Vector(arr2);
        System.out.println(v);
        System.out.println(v2);
        System.out.println(v3);
        double[][] arr = {{1,2,3},{4,5,6}};
        Matrix m = new Matrix(arr);
        Matrix m2 = new Matrix("{{7,8,9},{10,11,12}}");
        Matrix m3 = new Matrix(m2);
        System.out.println(m);
        System.out.println(m2);
        System.out.println(m3);

    }
}
