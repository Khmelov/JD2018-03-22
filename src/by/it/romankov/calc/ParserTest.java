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


}