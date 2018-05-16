package by.it.poprugo.jd02_06.calc;

public class Patterns {
    static final String SCALAR="((-?)(\\d+\\.?)+)";//"((-?)(\\d+\\.?)\\d*)"
    static final String VECTOR="\\{((-?(\\d+\\.?)+),?)+}";//"\\{((-?(\\d+\\.?))\\d*,?)+}"
    static final String MATRIX="\\{((\\{((-?(\\d+.?)+),?)+}),?)+}";//"\\{((\\{((-?(\\d+.?)\\d*),?)+}),?)+}"

    static final String OPERATION = "[\\+\\-\\*\\/]";
}
