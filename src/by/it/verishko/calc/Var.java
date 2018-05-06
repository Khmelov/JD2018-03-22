package by.it.verishko.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static Map<String, Var> variables = new HashMap<>();

    static Var saveVar(String nameVar, Var valueVar) throws CalcException {
        variables.put(nameVar, valueVar);
        try (PrintWriter printer = new PrintWriter(
                new FileWriter(
                        Util.getPathVarsTxt()
                )
        )) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                printer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            throw new CalcException("Не удалось сохранить переменную " + nameVar + "=" + valueVar, e);
        }


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
        throw new CalcException("Операция сложения " + this + " " + other + " невозможна\n");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + " " + other + " невозможна\n");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " " + other + " невозможна\n");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " " + other + " невозможна\n");
    }

}
