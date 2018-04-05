package by.it.shekh.jd01_01;

public class Main {

    public static void main (String[] args) {
        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет, люди");
        hello.printSlogan();

        Args argsObj=new Args(args);
        argsObj.print();

    }
}
