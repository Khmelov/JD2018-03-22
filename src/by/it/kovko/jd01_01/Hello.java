package by.it.kovko.jd01_01;

//import com.sun.org.apache.xpath.internal.SourceTree;

public class Hello {

    private String default_slogan="Hello World!!!";
    private String slogan=default_slogan;

    void setSlogan(String newSlogan) {
        slogan = newSlogan;
    }

    void printSlogan(){
        System.out.println(slogan);
    }

    public String getSlogan() {
        return slogan;
    }

    void toDefault(){
        slogan=default_slogan;
    }
}
