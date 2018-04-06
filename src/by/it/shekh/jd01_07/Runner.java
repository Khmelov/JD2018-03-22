package by.it.shekh.jd01_07;

public class Runner {

    public static void main(String[] args) {
        AbstractVar s1 = new Scalar(3.1415);
        AbstractVar s2 = new Scalar("3.1416");
        AbstractVar s3 = new Scalar((Scalar) s2);
        AbstractVar v = new Vector();


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
