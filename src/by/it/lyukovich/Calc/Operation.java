package by.it.lyukovich.Calc;

import java.util.HashMap;
import java.util.Map;

interface Operation {
    Map<String, Var> variables=new HashMap<>();
    public static Var saveVar(String nameVar, Var valueVar){
        variables.put(nameVar, valueVar);
        return valueVar;
    }


Var add(Var other);
Var sub(Var other);
Var mul(Var other);
Var div(Var other);

}
