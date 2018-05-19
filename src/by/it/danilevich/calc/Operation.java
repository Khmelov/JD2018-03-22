package by.it.danilevich.calc;

import java.io.IOException;

interface Operation {
    Var add(Var other) throws CallException, IOException;
    Var sub(Var other) throws CallException, IOException;
    Var mul(Var other) throws CallException, IOException;
    Var div(Var other) throws CallException, IOException;
}