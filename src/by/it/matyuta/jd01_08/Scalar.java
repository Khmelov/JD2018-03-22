package by.it.matyuta.jd01_08;


import by.it.matyuta.jd01_07.AbstractVar;

class Scalar extends AbstractVar {

private double value;

    Scalar (double value){
    this.value = value;
}

public Scalar (String str){
        this.value = Double.parseDouble(str);
}

public Scalar (Scalar otherScalar){
    this.value = otherScalar.value;
}

 @Override
 public String toString(){
     return Double.toString(value);

 }

}
