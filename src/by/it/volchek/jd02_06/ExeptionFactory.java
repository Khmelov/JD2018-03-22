package by.it.volchek.jd02_06;

/**
 * Created by volchek on 21.05.18.
 */
public class ExeptionFactory {
    void generateExeption(Exeption exeption){
         if (exeption instanceof ArithmeticExeption)
             new ArithmeticExeption().doExeption();
        else if (exeption instanceof ArrayIndexOutOfBoundsException)
             new ArrayIndexOutOfBoundsException().doExeption();
        else if (exeption instanceof NullPointerExeption)
             new NullPointerExeption().doExeption();
        else if (exeption instanceof StringIndexOutOfBounds)
             new StringIndexOutOfBounds().doExeption();

        }
    }

