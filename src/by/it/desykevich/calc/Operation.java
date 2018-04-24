package by.it.desykevich.calc;

public interface Operation {


        Var add(Var other) throws CalcException;
        Var sub(Var other);
        Var mul(Var other);
        Var div(Var other);

}
