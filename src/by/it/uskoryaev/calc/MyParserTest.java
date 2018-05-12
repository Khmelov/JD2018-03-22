package by.it.uskoryaev.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyParserTest {
    @Test
    public void add() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=2+5.3").toString(), "7.3");
    }

    @Test
    public void sub() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=5.0-2").toString(), "3.0");
    }

    @Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=5*5.0").toString(), "25.0");
    }

    @Test
    public void div() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=30/6").toString(), "5.0");
    }

}