package by.it.kovko.jd01_09;

abstract class Patterns {
    //static final String OPERATION="[-+/\\*]";
    //static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String OPERATION="(?<=[^-+/\\*])[-+/\\*]";
    static final String SCALAR="-?[0-9]+\\.?[0-9]*(e-?[0-9]+\\.?[0-9]*+)?";
    static final String VECTOR="\\{("+SCALAR+",?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
}
