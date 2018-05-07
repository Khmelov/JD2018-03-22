package by.it.poprugo.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    public static Var saveVar(String nameVar, Var valueVar) throws CalcExeption {
        //этот метод должен в карту сохранить значение
        variables.put(nameVar, valueVar);
    // до return valueVar; создадим 24.04
        variables.put(nameVar,valueVar); //если такой переменной раньше (?) не было (в put - null), то надо дописать,
                                        // а если (?) была - перезаписать
                                        // можно оптимизировать дозапись
        try (PrintWriter printer = new PrintWriter(new FileWriter(Util.getPathVarsTxt()))) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                printer.println(entry.getKey()+"="+entry.getValue());
            }



        } catch (IOException e) {
            throw new CalcExeption("Не удалось сохранить переменную"+nameVar+"="+valueVar,e); // вместо e.printStackTrace();
        }


        return valueVar;
    }

    /*static Var createVar(String strVar) { - БЫЛО ДО 13й лекции
        strVar=strVar.replaceAll("\\s+","").trim();
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
//        if (strVar.matches(Patterns.MATRIX))
//            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return null; // !!! I've missed !!!
        return null; // надо сгенерировать сообщение об ошибке
    }*/
    static Var createVar(String strVar) throws CalcExeption {
        strVar = strVar.replaceAll("\\s+", "").trim();
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
//        if (strVar.matches(Patterns.MATRIX))
//            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return null; // !!! I've missed !!!
        /* return null;- БЫЛО ДО 13й лекции*/
        throw new CalcExeption("Impossible to create"+strVar);
    }

    private double value;

    @Override
    public String toString() {
        //return Double.toString(value);
        return "Это класс AbstractVar";
    }

    //    @Override - БЫЛО ДО 13й лекции
//    public Var add(Var other) {
//        System.out.printf("Operation %s+%s is impossible\n",this,other);
//        return null;
//    }
    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("Operation " + this + "+" + other + " is impossible");
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption("Operation " + this + "-" + other + " is impossible");
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption("Operation " + this + "*" + other + " is impossible");
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption("Operation " + this + "/" + other + " is impossible");
        }


}
