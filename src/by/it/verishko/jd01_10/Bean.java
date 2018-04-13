package by.it.verishko.jd01_10;

class Bean {
    @Param(a = 8, b = 10)
    double sum(int c, int d) {
        return c + d;
    }

    @Param(a = 80, b = 100)
    double max(int c, int d) {
        return c > d ? c : d;
    }

    @Param(a = 800, b = 1000)
    static double min(int c, int d) {
        return c < d ? c : d;
    }

    static double avg(int c, int d) {
        return (c + d) / 2.0;
    }
}
