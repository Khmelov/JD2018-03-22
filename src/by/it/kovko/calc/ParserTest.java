package by.it.kovko.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {


    @Test (timeout = 1500)
    public void scalar() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=2+5.3").toString(),"7.3");
        assertEquals(parser.calc("B=A*3.5").toString(),"25.55");
        assertEquals(parser.calc("B1=B+0.11*-5").toString(),"25.0");
        assertEquals(parser.calc("B2=A/2-1").toString(),"2.65");

    }

    @Test (timeout = 1500)
    public void vector() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");
    }

    @Test (timeout = 1500)
    public void matrix() throws Exception {
        Parser parser = new Parser();
        parser.calc("M1={{2,3,4},{5,6,7}}");
        parser.calc("M2={{2,3,11},{12,5,14}}");
        parser.calc("M8={{2,3},{4,5},{6,7}}");
        parser.calc("M4={{2,3},{4,5}}");
        parser.calc("M5={{2,3},{4,5}}");
        assertEquals(parser.calc("M3=M1+M2").toString(),
                "{{4.0, 6.0, 15.0}, {17.0, 11.0, 21.0}}");
        assertEquals(parser.calc("M6=M4*M5").toString(),
                "{{16.0, 21.0}, {28.0, 37.0}}");
        assertEquals(parser.calc("M7=M6-M4").toString(),
                "{{14.0, 18.0}, {24.0, 32.0}}");
        assertEquals(parser.calc("M9=M8*M4").toString(),
                "{{16.0, 21.0}, {28.0, 37.0}, {40.0, 53.0}}");

//        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
//        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");
    }

    @Test (timeout = 1500)
    public void input() throws Exception{
        Parser parser = new Parser();
        assertEquals(parser.calc("15").toString(),"15.0");
        assertEquals(parser.calc("{15,13,12,5,0}").toString(),
                "{15.0, 13.0, 12.0, 5.0, 0.0}");
        assertEquals(parser.calc("{{15,13,12},{5,0,7}}").toString(),
                "{{15.0, 13.0, 12.0}, {5.0, 0.0, 7.0}}");
    }

}