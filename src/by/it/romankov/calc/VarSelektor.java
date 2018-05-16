package by.it.romankov.calc;

public class VarSelektor {

    Var getVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);

        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        return null;
    }
}
