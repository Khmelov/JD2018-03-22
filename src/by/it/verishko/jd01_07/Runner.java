package by.it.verishko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar s = new Scalar(3.14);
        AbstractVar s1 = new Scalar("123");
        Scalar s2 = new Scalar((Scalar) s1);
        AbstractVar v = new Vector(new double[]{1.0, 2.0, 4.0});
        AbstractVar v1 = new Vector((Vector) v);
        AbstractVar v2 = new Vector("{1.0, 2.0, 4.0}");
        Matrix m = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Matrix m1 = new Matrix((Matrix) m);
        Matrix m2 = new Matrix("{{ 1.0, 2.0 }, { 3.0, 4.0 }}");
        Object o = new Scalar(10);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(v);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(m);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(o);
    }
}
