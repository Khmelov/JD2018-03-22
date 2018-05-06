package by.it.danilevich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> variables= new HashMap<>();

    static Var saveVar(String nameVar, Var valueVar) throws CallException {
        variables.put(nameVar, valueVar);
        try {
            PrintWriter printer = new PrintWriter(new FileWriter(Util.getPathVarsTxt()));
            for (Map.Entry<String, Var> entry: variables.entrySet()){
                printer.println(entry.getKey()+"="+entry.getValue());
            }

        } catch (IOException e) {
            throw new CallException("Не удалось сохранить переменную" + nameVar + " "+valueVar, e);
          //  e.printStackTrace();
        }
        return valueVar;
    }
    static Var createVar(String strVar) throws CallException {
        if (strVar.matches(Patterns.SCALAR) ) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR) ) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX) ) return new Matrix(strVar);
        else if (strVar.matches(Patterns.VARNAME) ) return variables.get(strVar);
        throw new CallException("Ошибка обработки: " + strVar);
    }

    @Override
    public Var add(Var other) throws CallException {
        throw new CallException("Операция сложения " + this + " c " + other + " невозможна");
     //   System.out.println("Операция сложения " + this + " c " + other + " невозможна");
     //   return null;
    }

    @Override
    public Var sub(Var other) throws CallException{
        System.out.println("Операция вычитания " +   this + " c " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) throws CallException{
        System.out.println("Операция умножения "  + this + " c " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) throws CallException{
        System.out.println("Операция деления " + this + " c " + other + " невозможна");
        return null;
    }
    @Override
    public String toString(){
        return "Это класс Абстракт";
    }

}
