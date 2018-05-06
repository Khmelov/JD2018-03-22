package by.it.danilevich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CallException{
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()){
            String[] strOp =expression.split(Patterns.OPERATION);
            Var one = Var.createVar(strOp[0]);
            Var two = Var.createVar(strOp[1]);
            String operation = m.group();
            if (operation.equals("=")&& strOp[0].matches(Patterns.VARNAME)) return Var.saveVar(strOp[0], two);
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }

        }
       return Var.createVar(expression);
    }



}
