package by.it.kirova.calc;

import com.oracle.tools.packager.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    public static Var saveVar(String nameVar, Var valueVar) throws CalcException {
        //Var put = variables.put(nameVar, valueVar);
        variables.put(nameVar, valueVar);
        try (PrintWriter printer = new PrintWriter(new FileWriter(Util.getPathVarsTxt()))) {
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

    public static void printvar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            String key = entry.getKey();
            Var value = entry.getValue();
            printvarImpl(key, value);
        }
    }

    public static void sortvar() {
        SortedSet<String> sortedKeys = new TreeSet<>(ALPHABETICAL_ORDER);
        sortedKeys.addAll(variables.keySet());
        for (String key : sortedKeys) {
            Var value = variables.get(key);
//            System.out.print(key + "=");
//            Printer.print(value);
            printvarImpl(key, value);
        }
    }

    private static void printvarImpl(String key, Var value) {
        String message = value == null ?
                key + " is null" :
                key + "=" + value;
        Logger.println(message, Logger.MessageType.CALC_OUTPUT);
    }

    private static Comparator<String> ALPHABETICAL_ORDER =
            (String str1, String str2) -> {
                int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
                if (res == 0) {
                    res = str1.compareTo(str2);
                }
                return res;
            };

    @Override
    public String toString() {
        return "Это класс AbstractVar{}";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }
}
