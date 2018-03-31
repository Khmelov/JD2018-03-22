package by.it.volchek.jd01_01;

public class HelloWorld {
    public static void main(String[] args) {
        Hello hello;
        hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Hello World!");
        hello.printSlogan();

        Args args1 = new Args(args);
        //args1.setArgs();
        args1.printObj();


    }
}
