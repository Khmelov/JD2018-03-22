package by.it.desykevich.calc;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestParser {
    @Test
    public void TaskA() throws CalcException {
        Parser parser = new Parser();

        String actual = parser.calc("A=2+5.3");
        assertEquals("Error test", "7.3", actual);

        actual = parser.calc("B=A*3.5");
        assertEquals("Error test", "25.55", actual);

        actual = parser.calc("B1=B+0.11*-5");
        assertEquals("Error test", "25.0", actual);

        actual = parser.calc("B2=A/2-1");
        assertEquals("Error test", "2.65", actual);

        actual = parser.calc("3.8+26.2");
        assertEquals("Error test", "30.0", actual);

        actual = parser.calc("87.4-23");
        assertEquals("Error test", "64.4", actual);

        actual = parser.calc("2.1*5.9");
        assertEquals("Error test", "12.39", actual);

        actual = parser.calc("4/8");
        assertEquals("Error test", "0.5", actual);

    }

    @Test
    public void TaskB() throws CalcException {
        Parser parser = new Parser();

        String actual = parser.calc("C=B+(A*2)");
        assertEquals("Error test", "40.15", actual);

        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("Error test", "10.0", actual);

        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("Error test", "{10.0,15.0}", actual);

        actual = parser.calc("{2,3,4}*2");
        assertEquals("Error test", "{4.0,6.0,8.0}", actual);

        actual = parser.calc("{3,6,9}/3");
        assertEquals("Error test", "{1.0,2.0,3.0}", actual);

        actual = parser.calc("{2,3,4}-5");
        assertEquals("Error test", "{-3.0,-2.0,-1.0}", actual);

        actual = parser.calc("{2,3,4}+{5,6,7}");
        assertEquals("Error test", "{7.0,9.0,11.0}", actual);
    }

}
