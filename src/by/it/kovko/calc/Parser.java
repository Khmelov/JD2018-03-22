package by.it.kovko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc (String expression) throws CalcException {
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m=p.matcher(expression);
        if (m.find()){
            String[] strOp=expression.split(Patterns.OPERATION);
            Var two = Var.createVar(strOp[1]);
            String operation = m.group();
            if (operation.equals("="))
                Var.saveVar(strOp[0], two);
            Var one = Var.createVar(strOp[0]);
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;//Var.createVar(expression);
    }
}
