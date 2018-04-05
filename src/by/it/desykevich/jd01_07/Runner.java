package by.it.desykevich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar s=new Scalar(3.1415);
        AbstractVar s1=new Scalar("123");
        Scalar s2=new Scalar((Scalar) s1);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);

    }
}
