package by.it.lyukovich.jd_03_02;

import java.sql.Timestamp;

public class Book {
    private int bookid;
    private int categoryid;
    private Timestamp bookdateadded;
    private String bookname;
    private String booklang;
    private String bookauthors;
    private String bookcountry;
    private String bookdescription;
    private String bookformat;
    private String bookfilename;
    private String bookimgname;
    private int uploadedbyuser;


    public Book() {

    }
    public Book(int bookid, int categoryid, Timestamp bookdateadded, String bookname, String booklang,
                String bookauthors, String bookcountry, String bookdescription, String bookformat,
                String bookfilename, String bookimgname, int uploadedbyuser) {
        this.bookid = bookid;
        this.categoryid = categoryid;
        this.bookdateadded = bookdateadded;
        this.bookname = bookname;
        this.booklang = booklang;
        this.bookauthors = bookauthors;
        this.bookcountry = bookcountry;
        this.bookdescription = bookdescription;
        this.bookformat = bookformat;
        this.bookfilename = bookfilename;
        this.bookimgname = bookimgname;
        this.uploadedbyuser = uploadedbyuser;
    }

    @Override

    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", categoryid=" + categoryid +
                ", bookdateadded=" + bookdateadded +
                ", bookname='" + bookname + '\'' +
                ", booklang='" + booklang + '\'' +
                ", bookauthors='" + bookauthors + '\'' +
                ", bookcountry='" + bookcountry + '\'' +
                ", bookdescription='" + bookdescription + '\'' +
                ", bookformat='" + bookformat + '\'' +
                ", bookfilename='" + bookfilename + '\'' +
                ", bookimgname='" + bookimgname + '\'' +
                ", uploadedbyuser=" + uploadedbyuser +
                '}';
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public Timestamp getBookdateadded() {
        return bookdateadded;
    }

    public void setBookdateadded(Timestamp bookdateadded) {
        this.bookdateadded = bookdateadded;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooklang() {
        return booklang;
    }

    public void setBooklang(String booklang) {
        this.booklang = booklang;
    }

    public String getBookauthors() {
        return bookauthors;
    }

    public void setBookauthors(String bookauthors) {
        this.bookauthors = bookauthors;
    }

    public String getBookcountry() {
        return bookcountry;
    }

    public void setBookcountry(String bookcountry) {
        this.bookcountry = bookcountry;
    }

    public String getBookdescription() {
        return bookdescription;
    }

    public void setBookdescription(String bookdescription) {
        this.bookdescription = bookdescription;
    }

    public String getBookformat() {
        return bookformat;
    }

    public void setBookformat(String bookformat) {
        this.bookformat = bookformat;
    }

    public String getBookfilename() {
        return bookfilename;
    }

    public void setBookfilename(String bookfilename) {
        this.bookfilename = bookfilename;
    }

    public String getBookimgname() {
        return bookimgname;
    }

    public void setBookimgname(String bookimgname) {
        this.bookimgname = bookimgname;
    }

    public int getUploadedbyuser() {
        return uploadedbyuser;
    }

    public void setUploadedbyuser(int uploadedbyuser) {
        this.uploadedbyuser = uploadedbyuser;
    }





}
