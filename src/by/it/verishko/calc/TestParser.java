package by.it.verishko.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {
    @Test(timeout = 1500)
    public void add() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=2+5.3").toString(), "7.3");
    }

    @Test(timeout = 1500)
    public void mul() throws Exception {
        Parser parser = new Parser();
//        parser.calc("A=2+5.3");
        assertEquals(parser.calc("B=A*3.5").toString(), "25.55");
    }

    @Test(timeout = 1500)
    public void sub() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("B1=B+0.11*-5").toString(), "25.0");
    }

    @Test(timeout = 1500)
    public void div() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("B2=A/2-1").toString(), "2.65");
    }

//    @Test(timeout = 1500)
//    public void firV() throws Exception {
//        Parser parser = new Parser();
//        assertEquals(parser.calc("C=B+(A*2)").toString(), "40.15");
//    }
//
//    @Test(timeout = 1500)
//    public void secV() throws Exception {
//        Parser parser = new Parser();
//        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(), "10.0");
//    }
//
//    @Test(timeout = 1500)
//    public void thrV() throws Exception {
//        Parser parser = new Parser();
//        assertEquals(parser.calc("E={2,3}*(D/2)").toString(), "{10.0, 15.0}");
//    }

    @Test (timeout = 1500)
    public void vector() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");
    }
}