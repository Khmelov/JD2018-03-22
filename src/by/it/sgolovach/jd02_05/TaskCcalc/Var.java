package by.it.sgolovach.jd02_05.TaskCcalc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    static Var saveVar(String nameVar, Var valueVar) throws CalcException {
        variables.put(nameVar, valueVar); //можно оптимизитровать дозапись
        try (PrintWriter printer = new PrintWriter(
                new FileWriter(Util.getPathVarsTxt()
                )
        )) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                printer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            throw new CalcException(ConsoleRunner.rm.get(Messages.VAR1) + nameVar + "=" + valueVar, e);
        }


        return valueVar;
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return variables.get(strVar);
        throw new CalcException(ConsoleRunner.rm.get(Messages.VAR2) + strVar);

    }


    @Override
    public String toString() {
        return ConsoleRunner.rm.get(Messages.VAR3);
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.rm.get(Messages.VAR4) + this + "+" + other + ConsoleRunner.rm.get(Messages.VAR8));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.rm.get(Messages.VAR5) + this + "-" + other + ConsoleRunner.rm.get(Messages.VAR8));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.rm.get(Messages.VAR6) + this + "*" + other + ConsoleRunner.rm.get(Messages.VAR8));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.rm.get(Messages.VAR7) + this + "/" + other + ConsoleRunner.rm.get(Messages.VAR8));
    }
}
