package by.it.verishko.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        Book book = new Encyclopedia("Блинов");
        Encyclopedia book2 = new Encyclopedia("Шилдт");
//        Book book2 = new Encyclopedia("Шилдт");
        System.out.println(book.read());
        System.out.println(book.toString());
        System.out.println(book2.toString());
        System.out.println(book.close());


    }
}
