package by.it.sgolovach.jd02_05.TaskCcalc;

abstract class Patterns {

    static final String EXPRESSION = "(\\([-+*/,{}.\\ 0-9A-z]+\\))";
    static final String OPERATION = "(?<=[^-{,+/*=])[-+*/=]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String VARNAME = "[a-zA-Z][a-zA-Z0-9]*";


}
