package by.it.desykevich.jd01_07;



public class Runner {
    public static void main(String[] args) {

        AbstractVar s=new Scalar(3.1415);
        System.out.println(s);

        Scalar s1=new Scalar((Scalar) s);
        System.out.println(s1);

        AbstractVar s2=new Scalar("123");
        System.out.println(s2);



        Vector vector1 = new Vector(new double[]{1,2,3});
        System.out.println("Vector1="+ vector1);

        Vector vector2=new Vector(vector1);
        System.out.println("Vector2:"+vector2);

        Vector vector3=new Vector("{1,2,4}");
        System.out.println("Vector3:"+vector3);






    }
}
