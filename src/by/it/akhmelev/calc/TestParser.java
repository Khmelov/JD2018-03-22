package by.it.akhmelev.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {
    @Test
    public void add() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=2+5.3").toString(),"7.3");
    }

    @Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        assertEquals(parser.calc("B=A*3.5").toString(),"25.55");
    }


}