package by.it.shvedov.jd01_10;

public class Bean {
    @Param(a=8, b=10)
    double sum(int c, int d){
        return c+d;
    }
    @Param(a=8, b=10)
    static double max(int c, int d){
        return c>d? c:d;
    }
    @Param(a=8, b=10)
     double min(int c, int d){
        return c<d? c:d;
    }
    static double avg(int c, int d){
        return (c+d)/2.0;
    }
}
