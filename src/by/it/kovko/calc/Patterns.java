package by.it.kovko.calc;

abstract class Patterns {
    //static final String OPERATION="[-+/\\*]";
    //static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String OPERATION="(?<=[^-{,+/*=])[-*+/=]";

    static final String EXPR="\\(.*?\\)";
    static final String SCALAR="-?[0-9]+\\.?[0-9]*(e-?[0-9]+\\.?[0-9]*+)?";
    //static final String VECTOR="\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String VECTOR="\\{("+SCALAR+",?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
    static final String VARNAME="[A-Za-z][A-Za-z0-9]*";
}
