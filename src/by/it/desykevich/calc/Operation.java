package by.it.desykevich.calc;

public interface Operation {

        Var add(Var other) throws CalcException;
        Var sub(Var other) throws CalcException;
        Var mul(Var other) throws CalcException;
        Var div(Var other) throws CalcException;
        Var assign(Var other) throws CalcException;

}
