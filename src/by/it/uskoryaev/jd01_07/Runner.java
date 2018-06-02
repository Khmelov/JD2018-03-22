package by.it.uskoryaev.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar s1 = new Scalar(3.14);
        AbstractVar s2 = new Scalar("{3.14}");
        AbstractVar s3 = new Scalar((Scalar) s1);

        AbstractVar v1 = new Vector(new double[]{1.0, 2.0, 4.0});
        AbstractVar v2 = new Vector("{1.0, 2.0, 4.0}");
        AbstractVar v3 = new Vector((Vector) v1);


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}
