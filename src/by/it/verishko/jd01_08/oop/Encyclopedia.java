package by.it.verishko.jd01_08.oop;

public class Encyclopedia extends Book {


    Encyclopedia(String name) {
        super();
    }

    @Override
    public void open(int page) {
        System.out.println(this);
    }

    @Override
    public boolean close() {
        return super.read();
    }

    @Override
    public String toString() {
        return "Encyclopedia{}";
    }

    @Override
    public boolean read() {
        return true;
    }
}



//    print(book.buy(book));
//        print(book.sale(book));
//        print(book.open(book));
//        print(book.read(book));
//        print(book.close(book));