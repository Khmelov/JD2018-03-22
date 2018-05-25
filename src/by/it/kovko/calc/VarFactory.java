package by.it.kovko.calc;

public class VarFactory {
    Logger logger = Logger.getLogger();
    public Var getVar(String strVar) throws CalcException {
        strVar=strVar.replaceAll("\\s*","");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return Var.variables.get(strVar);
        logger.toLog(Errors.PROCESSING_ERROR.toString());
        throw new CalcException(Errors.PROCESSING_ERROR.toString());
    }
}
