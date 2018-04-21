package by.it.verishko.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    static Var saveVar(String nameVar, Var valueVar) {
        variables.put(nameVar, valueVar);
        return valueVar;
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+", "").trim();
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return variables.get(strVar);
        throw new CalcException("Ошибка обработки:" + strVar);
    }

    @Override
    public String toString() {
        return "Это класс Var{}";
    }

    @Override
    public Var add(Var other) throws CalcException {
        System.out.printf("Операция сложения %s+%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.printf("Операция вычитания %s-%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        System.out.printf("Операция умножения %s*%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.printf("Операция деления %s/%s невозможна\n", this, other);
        return null;
    }
}
