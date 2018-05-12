package by.it.kovko.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    List<String> priority =
            new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));

    List<String> operations;
    List<String> operands;

    private int getNumOperation() {
        // = + + * / - -
        int curnum = -1;
        int prior = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int p = priority.indexOf(op);
            if (p > prior) {
                curnum = i;
                prior = p;
            }
        }
        return curnum;
    }

     Var calc (String expression) throws CalcException {
        Pattern parentheses = Pattern.compile("(\\()([^\\(\\)]*)(\\))");
        Matcher mp= parentheses.matcher(expression);
        while (mp.find()){
//            System.out.println(mp.group(2));
            expression=expression.replaceFirst("(\\()([^\\(\\)]*)(\\))",calc(mp.group(2)).toString());
//            System.out.println("Expression = "+expression);
//            System.out.println(calc(mp.group(2)));
            mp.reset(expression);
        }
        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
        }
        while (operations.size() > 0) {
            int index = getNumOperation();
            String op = operations.remove(index);
            String oLeft = operands.get(index);
            String oRight = operands.remove(index + 1);
            operands.set(index, calcOneOperation(oLeft, op, oRight).toString());
        }
         //System.out.println("Последние операнд:"+operands.get(0));
         return Var.createVar(operands.get(0));
    }

    private Var calcOneOperation(String strVarLeft, String operaton, String strVarRight) throws CalcException {

        Var two = Var.createVar(strVarRight);
        if (operaton.equals("=") && strVarLeft.matches(Patterns.VARNAME))
            return Var.saveVar(strVarLeft, two);
        Var one = Var.createVar(strVarLeft);
        switch (operaton) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":{
                //System.out.println("Multiplication");
                return one.mul(two);}
            case "/":
                return one.div(two);
        }
        throw new CalcException("Нет такой операции");
    }
}
