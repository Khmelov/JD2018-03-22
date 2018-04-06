package by.it.shekh.jd01_07;

public class Runner {

    public static void main(String[] args) {
        AbstractVar s1 = new Scalar(3.1415);
        AbstractVar s2 = new Scalar("3.1416");
        AbstractVar s3 = new Scalar((Scalar) s2);
        AbstractVar v1 = new Vector(1,3,4);
        AbstractVar v2=new Vector((Vector)v1);
        AbstractVar v3=new Vector("2 3.1241 4");
        double [][]mas={{12.3,213.3},{2.3,1.2}};
        AbstractVar m1=new Matrix(mas);
        AbstractVar m2=new Matrix((Matrix)m1);
        AbstractVar m3=new Matrix("{{12.3,213.3},{2.3,1.2}}");


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
