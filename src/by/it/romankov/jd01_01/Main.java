package by.it.romankov.jd01_01;

public class Main {

    public static void main(String[] args) {
	        Hello hello = new Hello();
	        hello.printSlogan();
	        hello.setSlogan("привет мир");
        hello.printSlogan();
        Args argObj = new Args(args);
        argObj.printArgs();
    }
}
