package by.it.sgolovach.jd02_06.calc;

public class VariableSelect {

    Variable getVariable(VarType varType,String str){
        Variable variable=null;
        switch (varType){
            case SCALAR:
                variable=new Scalar(str);
                break;
            case VECTOR:
                variable=new Vector(str);
                break;
            case MATRIX:
                variable=new Matrix(str);
                break;
        }

        return variable;

    }

}
