package by.it.lyukovich.Calc;

public class VarFactory{
    public Var getVar(String strVar){
        strVar=strVar.replaceAll("\\s*","");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return Var.variables.get(strVar);
        return null;
    }
}

