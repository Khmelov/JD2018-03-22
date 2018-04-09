package by.it.verishko.jd01_08.oop;

import java.sql.SQLOutput;

public abstract class Book implements Edition {

    @Override
    public String toString() {
        return "Book{}";
    }


    @Override
    public boolean read() {
        System.out.println("Прочесть " + this + " невозможно");
        return false;
    }
}
