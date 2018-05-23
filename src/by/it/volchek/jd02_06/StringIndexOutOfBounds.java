package by.it.volchek.jd02_06;


public class StringIndexOutOfBounds implements Exeption {
    @Override
    public void doExeption() {
        String s = "Hello!";
        s = s.substring(2,12);
    }
}
