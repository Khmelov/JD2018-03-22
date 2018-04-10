package by.it.romankov.jd01_07;

public class Runner {
    public static void main(String[] args) {
      double[] v ={1,2,4};

        AbstractVar s = new Scalar(3.14);
        AbstractVar s1 = new Scalar("123");
        Scalar s2 = new Scalar((Scalar) s1);
        Object o = new Scalar(10);
        AbstractVar v1 = new Vector(v);
      AbstractVar v2 = new Vector((Vector) v1);
      AbstractVar v3 = new Vector(v);
      AbstractVar s7 = new Vector("{1,2,4}");


//
//
//      System.out.println(s);
//      System.out.println(s1);
//      System.out.println(s2);
//      System.out.println(o);
//
//      System.out.println(v1);
//      System.out.println(v2);
//      System.out.println(v3);


    }
}
