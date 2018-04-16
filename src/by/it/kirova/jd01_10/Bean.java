package by.it.kirova.jd01_10;

public class Bean {
    @Param(a = 8, b = 10)
    public double sum(int c, int d) {
        return c + d;
    }

    @Param(a = 80, b = 100)
    public static double max(int c, int d) {
        return c > d ? c : d;
    }

    public double min(int c, int d) {
        return c < d ? c : d;
    }

    @Param(a = 800, b = 1000)
    public static double avg(int c, int d) {
        return (c + d) / 2.0;
    }
}
