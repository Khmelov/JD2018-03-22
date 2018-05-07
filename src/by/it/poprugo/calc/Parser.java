package by.it.poprugo.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expresion) throws CalcExeption {
        //2/0*3.0
        //String[] strOp=expresion.split(Patterns.OPERATION);
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expresion);
        if (m.find()) {
            String[] strOp = expresion.split((Patterns.OPERATION));
            String operatio = m.group();
            Var two = Var.createVar(strOp[1]); // a=9
            if (operatio.equals("=") && strOp[0].matches(Patterns.VARNAME)) return Var.saveVar(strOp[0], two);
            Var one = Var.createVar(strOp[0]);
            //Var two = Var.createVar(strOne[1]);
            String operation = m.group();
            switch (operation) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }

        }
        return Var.createVar(expresion); //???
    }
}