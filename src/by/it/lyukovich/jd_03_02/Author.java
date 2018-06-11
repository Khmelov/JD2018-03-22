package by.it.lyukovich.jd_03_02;

public class Author {
    private int authorid;
    private String authorname;

    public Author(int authorid, String authorname) {
        this.authorid = authorid;
        this.authorname = authorname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", authorname='" + authorname + '\'' +
                '}';
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
}
