package by.it.romankov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
   @Test
  public void add()throws Exception{
       Parser parser = new Parser();
 assertEquals(parser.calc("A=2+5.3").toString(), "7.3");
   }
@Test
public void div()throws Exception{
    Parser parser = new Parser();
    assertEquals(parser.calc("B2=A/2-1").toString(), "2.65");

}
@Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("B=A*3.5").toString(),"25.55");
    }

    @Test
    public void sub() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("B=A-2").toString(),"5.3");
    }

    @Test (timeout = 1000)
    public void vector() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");
    }
}