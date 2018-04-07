package by.it.akhmelev.jd01_07;

public class Runner {

    public static void main(String[] args) {
        double d=123;
        Double dd=d;
        dd=dd+2;
        AbstractVar s=new Scalar(3.14);
        AbstractVar s1=new Scalar("123");
        Scalar s2=new Scalar((Scalar) s1);
        ((Scalar) s1).ssss();
        AbstractVar v=new Vector();
        Object s3=new Scalar((Scalar) v);
        Object o=new Scalar(10);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(v);
        System.out.println(o);
    }

}
