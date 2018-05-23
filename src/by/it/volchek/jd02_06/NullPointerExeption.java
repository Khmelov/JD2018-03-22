package by.it.volchek.jd02_06;

/**
 * Created by volchek on 21.05.18.
 */
public class NullPointerExeption implements Exeption{
    @Override
    public void doExeption() {
        Object obj = null;
        obj.hashCode();
    }
}
