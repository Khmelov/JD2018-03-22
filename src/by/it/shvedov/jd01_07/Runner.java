package by.it.shvedov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar v1=new Scalar(3.14);
        AbstractVar v2=new Vector(new double[]{1,2,3});
        System.out.println(v1);
        System.out.println(v2);
    }
}
