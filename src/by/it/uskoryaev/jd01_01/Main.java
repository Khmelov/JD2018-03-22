package by.it.uskoryaev.jd01_01;

public class Main {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Hello PVT");
        hello.printSlogan();
        Args argsObj = new Args(args);
        argsObj.printArgs();

    }
}
