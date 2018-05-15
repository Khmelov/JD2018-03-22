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
            throw new CallException(Util.getError(Err.falseSaveVar) + nameVar + " "+valueVar, e);
          //  e.printStackTrace();
        }
        return valueVar;
    }
    static Var createVar(String strVar) throws CallException {
        if (strVar.matches(Patterns.SCALAR) ) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR) ) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX) ) return new Matrix(strVar);
        else if (strVar.matches(Patterns.VARNAME) ) return variables.get(strVar);
        throw new CallException(Util.getError(Err.errorProces) + strVar);
    }

    @Override
    public Var add(Var other) throws CallException {
        throw new CallException(Util.getError(Err.OperationAdd) + this +
                Util.getError(Err.With)+ other + Util.getError(Err.Impossible));
     //   System.out.println("Операция сложения " + this + " c " + other + " невозможна");
     //   return null;
    }

    @Override
    public Var sub(Var other) throws CallException{
        System.out.println(Util.getError(Err.OperationSub) + this +
                Util.getError(Err.With)+ other + Util.getError(Err.Impossible));
        return null;
    }

    @Override
    public Var mul(Var other) throws CallException{
        System.out.println(Util.getError(Err.OperationMult) + this +
                Util.getError(Err.With)+ other + Util.getError(Err.Impossible));
        return null;
    }

    @Override
    public Var div(Var other) throws CallException{
        System.out.println(Util.getError(Err.OperationDiv) + this +
                Util.getError(Err.With)+ other + Util.getError(Err.Impossible));
        return null;
    }
    @Override
    public String toString(){
        return Util.getError(Err.ItsAbstract);
    }

}
