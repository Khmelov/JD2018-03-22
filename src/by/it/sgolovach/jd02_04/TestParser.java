package by.it.sgolovach.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {

    @Test
    public void expression() throws Exception{
        Parser parser=new Parser();
        assertEquals(parser.calcExpression("A=2+5.3").toString(),"7.3");
        assertEquals(parser.calcExpression("B=A*3.5").toString(),"25.55");
        assertEquals(parser.calcExpression("B1=B+0.11*-5").toString(),"25.0");
        assertEquals(parser.calcExpression("B2=A/2-1").toString(),"2.65");
        assertEquals(parser.calcExpression("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calcExpression("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calcExpression("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");
    }


    @Test
    public void add() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("2+5.3").toString(), "7.3");
        assertEquals(parser.calc("{1,2,3}+{3,4,5}").toString(), "{4.0, 6.0, 8.0}");
        assertEquals(parser.calc("{{1,2}{4,5}}+{{3,4}{7,5}}").toString(), "{{4.0, 6.0}, {11.0, 10.0}}");
    }

    @Test
    public void sub() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("6.5-5.5").toString(), "1.0");
        assertEquals(parser.calc("{1,2,3}-{3,4,5}").toString(), "{-2.0, -2.0, -2.0}");
        assertEquals(parser.calc("{{1,2}{4,5}}-{{3,4}{7,5}}").toString(), "{{-2.0, -2.0}, {-3.0, 0.0}}");
    }

    @Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("7.3*3.5").toString(), "25.55");
        assertEquals(parser.calc("{1,2,3}*{3,4,5}").toString(), "26.0");
        assertEquals(parser.calc("{{1,2}{4,5}}*{{3,4}{7,5}}").toString(), "{{17.0, 14.0}, {47.0, 41.0}}");
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