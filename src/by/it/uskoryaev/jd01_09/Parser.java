package by.it.uskoryaev.jd01_09;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expretion){
        //2.0*3/0
        String [] strOP = expretion.split(Patterns.OPERATION);
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expretion);
        if (m.find()){
            String [] strOp = expretion.split(Patterns.OPERATION);
            Var one = Var.createVar(strOP[0]);
            Var two = Var.createVar(strOP[1]);
            String operation = m.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return Var.createVar(expretion);
    }
}
