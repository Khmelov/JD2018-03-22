package by.it.kirova.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private List<String> priority = new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));
    private List<String> operations;
    private List<String> operands;

    private int getNumOperation() {
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

    public Var calc(String expression) throws CalcException {
        Deque<String> deque = new ArrayDeque<>();
        String current = "";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case '(':
                    if(!current.isEmpty()){
                        deque.add(current);
                        current = "";
                    }
                    deque .add("(");
                    break;
                case ')':
                    String str = deque.pollLast();
                    while (str != "(")
                    {
                        current = str + current;
                        str = deque.pollLast();
                    }
                    Var calced = calc_impl(current);
                    current = "";
                    deque.add(calced.toString());
                    break;
                default:
                    current += c;
                    break;
            }
        }

        String expr = "";
        for (String t: deque) {
            expr += t;
        }
        expr += current;
        return calc_impl(expr);
    }


    private Var calc_impl(String expression) throws CalcException {
        operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        operations = new ArrayList<>();

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
            // String operation = m.group();
        }
        while (operations.size() > 0) {
            int index = getNumOperation();
            String op = operations.remove(index);
            String oLeft = operands.get(index);
            String oRight = operands.remove(index + 1);
            operands.set(index, calcOneOperation(oLeft, op, oRight).toString());
        }
        return Var.createVar(operands.get(0));


    }


    private Var calcOneOperation(String strVarLeft, String operation, String strVarRight) throws CalcException {
        strVarLeft = strVarLeft.trim();
        strVarRight = strVarRight.trim();
        Var two = Var.createVar(strVarRight); // a=9
        if (operation.equals("=") && strVarLeft.matches(Patterns.VARNAME))
            return Var.saveVar(strVarLeft, two);
        Var one = Var.createVar(strVarLeft);
        switch (operation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }
        throw new CalcException("Нет такой операции");
    }
}

