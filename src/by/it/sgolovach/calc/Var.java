package by.it.sgolovach.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();


    static Var saveVar(String nameVar, Var valueVar) {
        variables.put(nameVar, valueVar);
        return valueVar;
    }

    static Var createVar(String strVar) {
        strVar = strVar.replace("\\s+", "").trim();
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return variables.get(strVar);
        return null;

    }


    @Override
    public String toString() {
        return "Это класс AbstractVar{}";
    }


    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s+%sневозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания %s-%sневозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s*%sневозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s/%sневозможна\n", this, other);
        return null;
    }
}
