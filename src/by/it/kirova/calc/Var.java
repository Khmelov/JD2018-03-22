package by.it.kirova.calc;

import java.util.*;

public abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    public static Var saveVar(String nameVar, Var valueVar) {
        variables.put(nameVar, valueVar);
        return valueVar;
    }

    static Var createVar(String strVar) {
        strVar = strVar.replaceAll("\\s+", "").trim();
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

    public static void printvar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            String key = entry.getKey();
            Var value = entry.getValue();
            System.out.print(key + "=");
            Printer.print(value);
        }
    }

    public static void sortvar() {
        SortedSet<String> sortedKeys = new TreeSet<>(ALPHABETICAL_ORDER);
        sortedKeys.addAll(variables.keySet());
        for (String key: sortedKeys) {
            Var value = variables.get(key);
            System.out.print(key + "=");
            Printer.print(value);
        }
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
    public Var add(Var other) {
        System.out.printf("Операция сложения %s+%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания %s-%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s*%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s/%s невозможна\n", this, other);
        return null;
    }
}
