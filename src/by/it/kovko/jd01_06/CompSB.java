package by.it.kovko.jd01_06;

import java.util.Comparator;

public class CompSB implements Comparator<StringBuilder> {

    @Override
    public int compare(StringBuilder o1, StringBuilder o2) {
        if (o1.length()<o2.length())
            return -1;
        else if (o1.length()>o2.length())
            return 1;
        return 0;
    }
}
