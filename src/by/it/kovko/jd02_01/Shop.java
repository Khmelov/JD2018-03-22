package by.it.kovko.jd02_01;

public class Shop {

    private int maxCustomers=10; // Увеличил количество покупателе в секунду,
    // потому что с таими таймингами они не доходили до 30-40.
    private long pauseBetweenCustomers=1000;
    final private double PENSIONER_PROB=0.25;
    enum Goods{
        Молоко(1.33), Кефир(1.56), Хлеб(1.43), Сок(2.32), Масло(1.87),
        Колбаса(4.54), Кофе(3.54), Чай(3.43), Рыба(6.54), Консервы(3.21);
        private double price;
        Goods(double price){this.price=price;}
    }
    void open(long openTime){
        int cutomerCount=0;
        long t=0;
        int sec=0, customers, k;
        while ((t=t+pauseBetweenCustomers)<=openTime){
            System.out.print(++sec + " секунда");
            System.out.print(" Количество покупателей: " + Customer.numberOfCustomers());
            k=(sec/30)%2;
            customers=10+30*k+(1-2*k)*sec%30-Customer.numberOfCustomers();
            if (customers>maxCustomers) customers=maxCustomers;
            if (customers<0) customers=0;
            System.out.println(" Вошло покупателей: "+customers);
            for (int i=0;i<customers;++i){
                if (Math.random()<PENSIONER_PROB)
                    new Thread(new Pensioner(++cutomerCount,this)).start();
                else
                    new Thread(new Customer(++cutomerCount,this)).start();
            }
            Util.sleep(pauseBetweenCustomers);
        }
    }
}
