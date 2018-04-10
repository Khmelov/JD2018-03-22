package by.it.poprugo.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expresion) {
        //2/0*3.0
        //String[] strOp=expresion.split(Patterns.OPERATION);
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expresion);
        if (m.find()) {
            String[] strOne = expresion.split((Patterns.OPERATION));
            Var one = Var.createVar(strOne[0]);
            Var two = Var.createVar(strOne[1]);
            String operation = m.group();
            switch (operation) {
                case "+": return one.add(two);
            }

        }
        return Var.createVar(expresion); //???
    }
}