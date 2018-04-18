package by.it.desykevich.jd01_10;

public class Bean {

    @Param(a=8,b=10)
    static double sum(int a,int b){
        return a+b;
    }
    @Param(a=8,b=10)
    double max(int a,int b){
        return Math.max(a,b);
    }
    @Param(a=8,b=10)
    double min(int a,int b){
        return Math.min(a,b);
    }

    static  double avg(int a,int b){
        return (a+b)/2.0;
    }
}
