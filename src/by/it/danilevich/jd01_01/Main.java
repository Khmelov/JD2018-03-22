package by.it.danilevich.jd01_01;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Good luck");
        hello.printSlogan();
        hello.setSlogan("Hello");
        Args.printArgs(args);
    }
}
