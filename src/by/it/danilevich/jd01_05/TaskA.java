package by.it.danilevich.jd01_05;

public class TaskA {
    public static void main(String[] args) {
    step1();
    step2();
    step3();
    }

    public static void step1(){
        double x = 0.3;
        double a = 756.13;
        double z = Math.cos( Math.pow(x*x + (Math.PI/6),5 ));
        z = z - Math.sqrt(x*Math.pow(a,3));
        z = z - Math.log( Math.abs(a - 1.12*x)/4) ;
        System.out.println("z= "+z);
    }
    public static void step2(){
        double a = 1.21;
        double b = 0.371;
        double y = Math.tan(Math.pow( a+ b, 2));
        y = y - Math.cbrt(a+1.5) + a*Math.pow(b,5);
        y = y - b/Math.log(Math.pow(a,2)) ;
        System.out.println("y= "+y);
    }
    public static void step3(){
        double x = 12.1;
        for (double a = -5; a <=12; a = a+3.75) {
            double f = Math.exp(a*x) - 3.45*a;
            System.out.printf("При а= %6.2f f=%g%n", a,f);
        }
       }




}
