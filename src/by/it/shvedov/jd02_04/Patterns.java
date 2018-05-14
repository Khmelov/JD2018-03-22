package by.it.shvedov.jd02_04;

public abstract class  Patterns {
    static final String OPERATION="(?<=[^-{,+/*=])[-*+/=]";
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String VECTOR="\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String VARNAME="[a-zA-Z][a-zA-Z0-9]*";
}
