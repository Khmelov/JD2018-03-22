package by.it.verishko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar s = new Scalar(3.14);
        AbstractVar s1 = new Scalar("123");
        Scalar s2 = new Scalar((Scalar) s1);
        AbstractVar v = new Vector(new double[]{1, 2, 3});
        AbstractVar v1 = new Vector((Vector) v);
        AbstractVar v2 = new Vector("{1,2,4}");
//        AbstractVar m = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
//        AbstractVar m1 = new Matrix((Matrix) m);
//        AbstractVar m2 = new Matrix("{{1, 2, 3}, {4, 5, 6}}");
        Object o = new Scalar(10);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(v);
        System.out.println(v1);
        System.out.println(v2);
//        System.out.println(m);
//        System.out.println(m1);
//        System.out.println(m2);
        System.out.println(o);
    }
}
