package by.it.pashkevich.jd01_09;

abstract class Patterns {
    static final String OPERATION = "[-+*/]"; //TODO Negative Incorrect
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String VECTOR="\\(((-?[0-9]+\\.?[0-9]*),?)+)";
    static final String MATRIX="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
}
