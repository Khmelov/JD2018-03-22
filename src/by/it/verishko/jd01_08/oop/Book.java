package by.it.verishko.jd01_08.oop;

public abstract class Book implements Edition {

    @Override
    public String toString() {
        return "Book{}";
    }
    public void open(int page){
        System.out.println("Открываем книгу");
    }

    @Override
    public boolean read() {
        System.out.println("Прочесть " + this + " невозможно");
        return false;
    }
}
