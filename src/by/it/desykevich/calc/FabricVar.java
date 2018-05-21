package by.it.desykevich.calc;

public class FabricVar {

    public static Var createVar (String varString){

        Var var=null;

        if (varString.matches(Patterns.SCALAR)) return new Scalar(varString);
        if (varString.matches(Patterns.VECTOR)) return new Vector(varString);
        if (varString.matches(Patterns.KEY)) return Variable.getValue(varString);
        return var;
    }
}
