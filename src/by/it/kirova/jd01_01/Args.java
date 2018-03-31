package by.it.kirova.jd01_01;

public class Args {

    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }


   /*
    void printArgs () {
        int i = 0; // в примере ошибка i = 1
        for (String arg : args) {
            i++;
            System.out.println("Аргумент № " + i + " = " + arg);
        }
    }
   */


    //альтернатива методу из примера:
    void printArgs () {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент № " + (i+1) + " = " + args);
        }
    }


}
