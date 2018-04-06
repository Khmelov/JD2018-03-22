package by.it.kovko.jd01_07;


public class Runner{
    public static void main(String[] args) {
        Scalar s1 = new Scalar();
        Scalar s2 = new Scalar(3.14);
        Scalar s3 = new Scalar(s2);
        Scalar s4 = new Scalar("3.14");
        System.out.println(s1+"\n"+s2+"\n"+s3+"\n"+s4);
        double t[] = {1,3,4,5,6};
        Vector v1 = new Vector();
        Vector v2 = new Vector(t);
        Vector v3  = new Vector(v2);
        Vector v4= new Vector(v3.toString());
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        String s="{{1,2},{3,4}}";
        double m[][]={{1,2},{3,4}};
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix(s);
        Matrix m3 = new Matrix(m2);
        Matrix m4 = new Matrix(m);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);
    }
}
