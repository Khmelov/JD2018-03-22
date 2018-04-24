package by.it.danilevich.calc;

interface Operation {
    Var add(Var other) throws CallException;
    Var sub(Var other) throws CallException;
    Var mul(Var other) throws CallException;
    Var div(Var other) throws CallException;
}