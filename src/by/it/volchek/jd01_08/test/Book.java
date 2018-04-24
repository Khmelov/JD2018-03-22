package by.it.volchek.jd01_08.test;

/**
 * Created by volchek on 09.04.18.
 */
public  abstract class Book implements Izdanie {

    private int Year;
    private String Author;
    @Override
    public String getAuthor() {
        return this.Author;
    }

    @Override
    public int getYear() {
        return this.Year;
    }
}
