package by.it.kirova.calc;

abstract class Patterns {
    static final String OPERATION = "[+*/=]|(?<=[a-zA-Zа-яА-ЯёЁ0-9}])-";
    static final String SCALAR = "-?(\\d*)?(\\.\\d+)?(?<=\\d)([Ee]-?(\\d*))?";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String VARNAME = "[a-zA-Zа-яА-ЯёЁ][a-zA-Zа-яА-ЯёЁ0-9]*";
}
