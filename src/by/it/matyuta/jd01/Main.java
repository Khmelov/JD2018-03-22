package by.it.matyuta.jd01;

public class Main {
    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("ПРивет, мир!");
        hello.printSlogan();
        Args argObj = new Args(args);
        argObj.printArgs();
    }
}
