package by.it.volchek.Calc;

import java.util.*;

/**
 * Created by volchek on 07.04.18.
 */
abstract class Var implements Operation {

    private static Map<String, Var> Variables = new HashMap<>();

    public static Var saveVar (String nameVar, Var valueVar){
        Variables.put(nameVar, valueVar);
        return valueVar;

    }
    public static void printVariables (){
        for (Map.Entry<String, Var> stringVarEntry : Variables.entrySet()) {
            System.out.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
        }
    }
    public static void sortVariables (){

        TreeMap<String, Var> sortedVariables = new TreeMap<>();
        for (Map.Entry entry: Variables.entrySet()){
            sortedVariables.put((String )entry.getKey(),(Var) entry.getValue());

        }
        for (Map.Entry<String, Var> stringVarEntry : sortedVariables.entrySet()) {
            System.out.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
        }
    }


    static Var createVar (String strVar){
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return Variables.get(strVar);
        return null;

    }
    @Override
    public String toString() {
        return "Это класс AbstractVar";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s+%s невозможна\n", this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания %s-%s невозможна\n", this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s*%s невозможна\n", this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s/%s невозможна\n", this,other);
        return null;
    }
}
