package by.it.kirova.jd01_01;

public class Main {

    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет, Мир!");
        hello.printSlogan();
        Args args1 = new Args(args);
        args1.printArgs();


    }
}
