package by.it.kirova.jd01_09;

abstract class Patterns {
    static final String OPERATION = "[-+*/]"; //Negative [+*/]|(?<=[0-9}])-
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    //RegEx with Exponent  -?(\d*)?(\.\d+)?(?<=\d)([EeЕе]-?(\d*))?
}
