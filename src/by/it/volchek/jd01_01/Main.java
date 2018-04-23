package by.it.volchek.jd01_01;

public class Main {

    public static void main(String[] args) {

        myPow(5, 8);

    }


    private static void myPow(int a, int b) {

        for (int j = 0; j < a; j++) {

            for (int i = 0; i < b; i++) {

                long d = (long) Math.pow(j, i);
                System.out.print(d + " ");
            }
            System.out.println();


        }


    }
}
