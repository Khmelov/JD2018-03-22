package by.it.kovko.calc;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    public static void printVar(){
        Set<Map.Entry<String, Var>> entries = variables.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.toString());
        }
    }
    public static void sortVar(){
        Comparator<Map.Entry<String, Var>> comp = (Map.Entry<String, Var> o1, Map.Entry<String, Var> o2) -> (o1.getKey().compareTo(o2.getKey()));
        TreeSet<Map.Entry<String, Var>> sorted = new TreeSet<>(comp);
        sorted.addAll(variables.entrySet());
        for (Map.Entry<String, Var> entry : sorted) {
            System.out.println(entry.toString());
        }

    }
    public static Var saveVar(String s, Var two) throws CalcException {
        variables.put(s,two); // добавить для дозаписи
        try (PrintWriter printer = new PrintWriter(new FileWriter(Util.getPathVarsTxt()))){
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                printer.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (IOException e) {
            throw new CalcException("Не удалось сохранить переменную "+ s+"="+two);
        }
        return two;
    }


    static Var createVar(String strVar) throws CalcException {
        strVar=strVar.replaceAll("\\s*","");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR)) {
            //System.out.println("вектор "+strVar);

            return new Vector(strVar);

        }
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return variables.get(strVar);
        //System.out.println("Не вернул вектор");
        throw new CalcException("Ошибка обработки");
    }

    @Override
    public String toString() {
        return "Это клас AbstractVar";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw  new CalcException("Операция сложения "+this+" "+other+" невозможна\n");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw  new CalcException("Операция вычитания "+this+" "+other+" невозможна\n");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw  new CalcException("Операция умножения "+this+" "+other+" невозможна\n");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw  new CalcException("Операция деления "+this+" "+other+" невозможна\n");
    }


}
