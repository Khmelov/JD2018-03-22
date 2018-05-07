package by.it.sgolovach.jd01_10;

public class Bean {

    @Param(a = 2, b = 5)
    double sum(int c, int d) {
        return c + d;
    }

    @Param(a = 4, b = 10)
    static double max(int c, int d) {
        return c > d ? c : d;
    }

    double min(int c, int d) {
        return c < d ? c : d;
    }

    @Param(a = 8, b = 20)
    static double avg(int c, int d) {
        return (c + d) / 2.0;
    }

}
