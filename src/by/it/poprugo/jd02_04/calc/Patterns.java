package by.it.poprugo.jd02_04.calc;

public abstract class  Patterns {
    static final String OPERATION="(?<=[^-={,+*/])[-+*/=]"; //(?)} усовершенствовали, чтобы работали и 3--2 {-8.9,-2}
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String VECTOR="\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String VARNAME="[a-zA-Z][a-zA-Z0-9]*";
}
