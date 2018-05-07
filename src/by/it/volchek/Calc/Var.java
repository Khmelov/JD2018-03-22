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
        for (Map.Entry entry: Variables.entrySet()){
            sortedVariables.put((String )entry.getKey(),(Var) entry.getValue());

        }
        for (Map.Entry<String, Var> stringVarEntry : sortedVariables.entrySet()) {
            System.out.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
        }
    }


    static Var createVar (String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return Variables.get(strVar);
        throw new CalcException("ОШИБКА парсинга" + strVar);

    }
    @Override
    public String toString() {
        return "Это класс AbstractVar";
    }

    @Override
    public Var add(Var other) throws CalcException{

        throw new CalcException("Операция сложения" + this +"и"+other+"невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания" + this +"и"+other+ "невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения" + this +"и"+other +"невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления" + this +"и"+other +"невозможна");
    }
}
