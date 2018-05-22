package by.it.volchek.jd02_06;


public class ArithmeticExeption implements Exeption {

    @Override
    public void doExeption() {
        int i = (int)Math.random() / 0;
    }
}
