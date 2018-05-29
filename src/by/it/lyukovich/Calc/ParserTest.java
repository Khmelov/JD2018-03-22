package by.it.lyukovich.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void add() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=2+5.3"),"7.3");

    }
    @Test
    public void sub() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("B2=A/2-1"),"2.65");
    }

    @Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        assertEquals(parser.calc("B=A*3.5"),"25.55");
    }

    @Test
    public void div() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("B2=A/2-1"),"2.65");
    }

    @Test
    public void vektor() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)"),"10.0");
    }

}