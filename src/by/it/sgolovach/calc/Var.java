package by.it.sgolovach.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();


    static Var saveVar(String nameVar, Var valueVar) {
        variables.put(nameVar, valueVar);
        return valueVar;
    }

    static Var createVar(String strVar) throws CalcException {
//        strVar = strVar.replace("\\s+", "").trim();
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return variables.get(strVar);
        throw new CalcException("Ошибка обработки: " + strVar);

    }


    @Override
    public String toString() {
        return "Это класс AbstractVar{}";
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна ");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна ");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умнжения " + this + "*" + other + " невозможна ");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна ");
    }
}
