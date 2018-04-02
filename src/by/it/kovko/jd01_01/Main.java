package by.it.kovko.jd01_01;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Args ar = new Args(args);
        System.out.println("Печать через объект");
        ar.printArgs();
        System.out.println("Печать через статический метод");
        Args.printArgs(args);
        Hello obj = new Hello();
        obj.printSlogan();
        obj.setSlogan("привет мир");
        obj.setSlogan("Новый привет мир");
        obj.printSlogan();
        obj.toDefault();
        System.out.println(obj.getSlogan());
    }
}
