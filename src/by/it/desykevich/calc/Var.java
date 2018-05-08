package by.it.desykevich.calc;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

  private static Map<String, Var> variables=new HashMap<>();
  public  static  Var saveVar (String nameVar, Var valueVar){
    variables.put(nameVar,valueVar);
    return valueVar;
  }

  static Var createVar(String strVar){
    strVar=strVar.trim().replace("\\s+","");
    if (strVar.matches(Patterns.SCALAR))
      return new Scalar(strVar);
    if (strVar.matches(Patterns.VECTOR))
      return new Vector(strVar);

//    if (strVar.matches(Pattern.MATRIX))
//      return new Matrix(strVar);
//    if (strVar.matches(Patterns.VARNAME))
    return null;


  }

     @Override
  public Var add(Var other)  {
       System.out.println("Операция сложения "+this+"+"+other+"невозможна");
       return null;


  }

  @Override
  public Var sub(Var other) {
    System.out.println("Операция вычитания "+this+"-"+other+"невозможна");
    return null;
  }

  @Override
  public Var mul(Var other) {
    System.out.println("Операция умножения "+this+"*"+other+"невозможна");
    return null;
  }

  @Override
  public Var div(Var other) {
    System.out.println("Операция деления"+this+"/"+other+"невозможна");
    return null;
  }
}
