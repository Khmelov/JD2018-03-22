package by.it.poprugo.jd02_04.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {

    @Test
    public void calc() throws CalcException {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=2+5.3".toString()),"7.3");
    }
}