package by.it.danilevich.calc;

import org.junit.Test;

import static org.junit.Assert.*;

    public class TestParser {
        @Test
        public void add() throws Exception {
            Parser parser = new Parser();
            parser.calc("A=2+5.3");
            parser.calc("B=A*3.5");
            assertEquals(parser.calc("A=2+5.3").toString(),"7.3");
            assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");

        }

        @Test
        public void mul() throws Exception {
            Parser parser = new Parser();
            parser.calc("A=2+5.3");
            parser.calc("B=A*3.5");
            parser.calc("C=B+(A*2)");
            parser.calc("D=((C-0.15)-20)/(7-5)");

            assertEquals(parser.calc("B=A*3.5").toString(),"25.55");
            assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
            assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10,15}");
        }

        @Test
        public void sub() throws Exception {
            Parser parser = new Parser();
            parser.calc("A=2+5.3");
            parser.calc("B=A*3.5");
            assertEquals(parser.calc("B1=B+0.11*-5").toString(),"25.0");
        }
        @Test
        public void viv() throws Exception {
            Parser parser = new Parser();
            parser.calc("A=2+5.3");
            parser.calc("B=A*3.5");
            parser.calc("B1=B+0.11*-5");
            assertEquals(parser.calc("B2=A/2-1").toString(),"2.65");
        }
    }

