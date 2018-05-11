package by.it.romankov.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    List<String>priority=new ArrayList <>(Arrays.asList("=","/","*","+","-"));
    List<String>operation ;
    List<String>operands;

    private int getNumoperation() {
        int curnum = 0;
        int prior = priority.indexOf(operation.get(curnum));
        for ( int i = 0; i < operation.size(); i++ ) {
            String op = operation.get(i);
            int p = priority.indexOf(op);
            if (p > prior) {
                curnum = i;
                prior = p;
            }
        }
        return curnum;
        }



    Var calc(String expression) throws CalcException{
        //2.0*3.0
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String[] strOp = expression.split(Patterns.OPERATION);
            String operaton = m.group();
            String strVarLeft=strOp[0];
            String strRight=strOp[1];
            Var two = Var.createVar(strOp[1]); // a=9
            if (operaton.equals("=") && strOp[0].matches(Patterns.VARNAME))
                return Var.saveVar(strVarLeft,two);
            Var one = Var.createVar(strRight);
            switch (operaton) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return Var.createVar(expression);
    }
}
