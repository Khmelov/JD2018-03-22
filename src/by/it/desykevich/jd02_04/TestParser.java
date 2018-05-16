package by.it.desykevich.jd02_04;

import org.junit.Test;

import java.lang.annotation.Target;

import static junit.framework.TestCase.assertEquals;

public class TestParser {

    @Test
    public void TaskA() throws Exception {
        Parser parser = new Parser();

        String actual=parser.calc("A=2+5.3");
        assertEquals(parser.calc("A=2+5.3").toString(),"7.3");

        assertEquals(parser.calc("B=A*3.5").toString(),"25.55");

        assertEquals(parser.calc("B1=B+0.11*-5").toString(),"25.0");

        assertEquals(parser.calc("B2=A/2-1").toString(),"2.65");


        actual=parser.calc("5.4+24.6");
        assertEquals("Error test", "30.0", actual);

        actual = parser.calc("102.5-3.5");
        assertEquals("Error test", "99.0", actual);

        actual = parser.calc("2.1*5.9");
        assertEquals("Error test", "12.39", actual);

        actual = parser.calc("4/8");
        assertEquals("Error test", "0.5", actual);
    }

    @Test
    public void TaskB() throws Exception {
        Parser parser = new Parser();

        String actual=parser.calc("A=2+5.3");

        assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");

        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");

        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0,15.0}");


        actual=parser.calc("{2,3,4}*2");
        assertEquals("Error test", "{4.0,6.0,8.0}", actual);

        actual = parser.calc("{3,6,9}/3");
        assertEquals("Error test", "{1.0,2.0,3.0}", actual);

        actual = parser.calc("{2,3,4}-5");
        assertEquals("Error test", "{-3.0,-2.0,-1.0}", actual);

        actual = parser.calc("{2,3,4}+{5,6,7}");
        assertEquals("Error test", "{7.0,9.0,11.0}", actual);
    }

//    @Test
//    public void mul() throws Exception {
//        Parser parser = new Parser();
//        parser.calc("A=2+5.3");
//        assertEquals(parser.calc("B=A*3.5").toString(),"25.55");
//    }


}
