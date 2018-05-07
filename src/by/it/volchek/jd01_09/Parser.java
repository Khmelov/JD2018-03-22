package by.it.volchek.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by volchek on 10.04.18.
 */
public class Parser {
    Var calc (String expression){
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()){
            String[] strOp = expression.split(Patterns.OPERATION);
            Var one = Var.createVar(strOp[0]);
            Var two = Var.createVar(strOp[1]);
            String operation = m.group();
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
