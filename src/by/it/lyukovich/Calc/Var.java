package by.it.lyukovich.Calc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Var implements Operation {
    public static Map<String, Var> variables = new HashMap<>();
    static VarFactory factory = new VarFactory();
    public static Var saveVar (String nameVar, Var valueVar){
        variables.put(nameVar, valueVar);
        return valueVar;
    }
    static Var createVar(String strVar) throws CalcException {
        return factory.getVar(strVar);
    }
    /*static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return variables.get(strVar);
        throw new CalcException("Ошибка: " + strVar);
    }*/

    public static void printVars (){
        for (Map.Entry<String, Var> stringVarEntry : variables.entrySet()) {
            System.out.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
        }
    }



    public static void sortVars (){
        TreeMap<String, Var> sortedVariables = new TreeMap<String, Var>(new Comparator<String>()
        {
            @Override
            public int compare(String obj1, String obj2)
            {
                if (obj1 == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                if (obj1.equals( obj2 )) {
                    return 0;
                }
                return (obj1.toLowerCase()).compareTo(obj2.toLowerCase());
            }
        });

        for (Map.Entry entry: variables.entrySet()){
            sortedVariables.put((String )entry.getKey(),(Var) entry.getValue());

        }
        for (Map.Entry<String, Var> stringVarEntry : sortedVariables.entrySet()) {
            System.out.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(
                "Операция сложения " + this + "+" + other + " невозможна"
        );
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
