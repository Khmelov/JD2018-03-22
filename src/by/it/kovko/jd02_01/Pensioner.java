package by.it.kovko.jd02_01;

class Pensioner extends Customer {
    Pensioner(int n, Shop shop) {
        super(n, shop);
        setTimeFactor(1.5);
        setName(getName()+" (пенсионер)");
    }
}
