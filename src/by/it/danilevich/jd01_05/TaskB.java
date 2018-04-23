package by.it.danilevich.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }
    private static void step4(){
        for (double a = 0; a <=2 ; a = a + 0.2) {
            double sum =0;
            for (int x = 1; x <=6 ; x++) {
                sum = sum + Math.pow(7,a) - Math.cos(x);
               }
            System.out.printf("При а=%4.2f,y=%g%n", a,sum);

        }
    }
    private static void step5(){
       for (double x = (-6+0.5); x <2 ; x = x +0.5) {
           double polX =x/2;
           double b;
           double a;
           if (polX>(-2)&&polX<=(-1)){
               b = Math.sin(x*x);
           }

           else if (polX>(-1)&&polX<(0.2)){
               b = Math.cos(x*x);
           }
           else if (polX==0.2){
               b = 1/(Math.tan(x*x));
           }
           else {
               System.out.printf("При x/2=%6.2f вычисления не определены%n", polX);
               continue;
           }

           a = Math.log10(Math.abs(b+2.74));

           System.out.printf("При x/2=%6.2f, a=%g%n", polX, a);
            }
       }



}
