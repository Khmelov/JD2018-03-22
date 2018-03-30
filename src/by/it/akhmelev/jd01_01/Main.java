package by.it.akhmelev.jd01_01;

public class Main {
    public static void main(String[] aaa) {
        Hello myCurrentSlogan = new Hello();
        myCurrentSlogan.printSlogan();
        myCurrentSlogan.setSlogan("Привет мир!");
        myCurrentSlogan.printSlogan();
        Args a = new Args();
        a.printArguments(aaa);
    }
}
