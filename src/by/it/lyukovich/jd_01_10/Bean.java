package by.it.lyukovich.jd_01_10;

class Bean {
    @Param(a=8, b=10)
    static double sum(int c, int d){
        return c+d;
    }
    @Param(a=3, b=9)
    static double max(int c, int d){
        if(c>d){return c;}else return d;
    }

    double min(int c, int d){
        if(c<d){return c;}else return d;
    }
    @Param(a=2, b=6)
    double avg(int c, int d){
        return (c+d)/2.;
    }
}
