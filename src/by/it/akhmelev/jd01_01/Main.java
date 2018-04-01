package by.it.akhmelev.jd01_01;

public class Main {
    public static void main(String[] args) {
        Hello hello=new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет мир.");
        hello.printSlogan();

        Args argsObj=new Args(args);
        argsObj.print();

    }

}
