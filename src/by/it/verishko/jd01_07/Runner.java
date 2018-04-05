package by.it.verishko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar s = new Scalar(3.14);
        AbstractVar s1 = new Scalar("123");
        Scalar s2 = new Scalar((Scalar) s1);
        AbstractVar v = new Vector();
        Object o = new Scalar(10);


        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(v);
        System.out.println(o);
    }
}
