package by.it.sgolovach.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String str = scaner.next();
        List<String> symbol = new ArrayList<>();
        List<String> symbol1 = new ArrayList<>();
        List<String> symbol2 = new ArrayList<>();
        List<String> symbol3 = new ArrayList<>();
        List<String> result = new ArrayList<>();
        symbol.add(")");symbol.add("(");symbol.add("]");
        symbol.add("[");symbol.add("}");symbol.add("{");

        Pattern p = Pattern.compile("[(){}\\[\\]]");
        Matcher m = p.matcher(str);
        while (m.find()) {
            String sym = m.group();
            if (sym.equals(symbol.get(0)) || sym.equals(symbol.get(1))) symbol1.add(sym);
            if (sym.equals(symbol.get(2)) || sym.equals(symbol.get(3))) symbol2.add(sym);
            if (sym.equals(symbol.get(4)) || sym.equals(symbol.get(5))) symbol3.add(sym);
        }

        if (!symbol1.isEmpty()) {
            int count1 = Collections.frequency(symbol1, symbol.get(0));
            int count2 = Collections.frequency(symbol1, symbol.get(1));
            if (symbol1.get(0).equals(symbol.get(0))
                    || count1 != count2 ||  count2 == 0 || symbol1.size() == 1)
                result.add("false");
            else result.add("true");
        }
        if (!symbol2.isEmpty()) {
            int count1 = Collections.frequency(symbol2, symbol.get(2));
            int count2 = Collections.frequency(symbol2, symbol.get(3));
            if (symbol2.get(0).equals(symbol.get(2))
                    || count1 != count2 || count2 == 0 || symbol2.size() == 1)
                result.add("false");
            else result.add("true");
        }
        if (!symbol3.isEmpty()) {
            int count1 = Collections.frequency(symbol3, symbol.get(4));
            int count2 = Collections.frequency(symbol3, symbol.get(5));
            if (symbol3.get(0).equals(symbol.get(4))
                    || count1 != count2  || count2 == 0 || symbol3.size() == 1)
                result.add("false");
            else result.add("true");
        }

        if (!result.isEmpty()) {
            int res = Collections.frequency(result, "false");
            if (res > 0) System.out.println("false");
            else System.out.println("true");
        }
    }
}
//((1+3)-(1/6))+{5,6,7}{{3,5,6},{6,5,6}}+[2] true
//(1+3-(1/6)+{5,6,7}{{3,5,6,{6,5,6}}+][2] false
//(1+3)-(1/6)+{{5,6,7}{{3,5,6},{6,5,6}}+[2] false