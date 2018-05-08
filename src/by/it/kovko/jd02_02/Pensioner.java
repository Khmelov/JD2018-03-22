package by.it.kovko.jd02_02;

public class Pensioner extends ConcreteCustomer {
    Pensioner(int i, Shop shop) {
        super(i, shop);
        setTimeFactor(1.5);
        setName(getName()+" (пенсионер)");
        setPriority(2);
    }
}
