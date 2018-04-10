package by.it.sgolovach.jd01_07;

public class Runner {

    public static void main(String[] args) {

//        AbstractVar s=new Scalar(3.1415);
//        AbstractVar v=new Vector(new double[]{1.0, 2.0, 4.0});
        AbstractVar v1 = new Matrix("{{1,2},{3,4}}");

        System.out.println(v1.toString());
//        AbstractVar s1 = new Scalar("123");
//        Scalar s2 =new Scalar((Scalar)s1);


//        System.out.println(s);
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(v);


    }

}
