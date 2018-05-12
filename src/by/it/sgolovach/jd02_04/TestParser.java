package by.it.sgolovach.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {


    @Test
    public void add() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("2+5.3").toString(), "7.3");
    }

    @Test
    public void sub() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("6.5-5.5").toString(), "1.0");
    }

    @Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("7.3*3.5").toString(), "25.55");
    }

    @Test
    public void div() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("7/2").toString(), "3.5");
    }

    @Test
    public void toStrin() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("7").toString(), "7.0");
        assertEquals(parser.calc("{1,2,3,4}").toString(), "{1.0, 2.0, 3.0, 4.0}");
        assertEquals(parser.calc("{{1,2},{8,3}}").toString(), "{{1.0, 2.0}, {8.0, 3.0}}");
    }

}