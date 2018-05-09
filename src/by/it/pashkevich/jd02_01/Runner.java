package by.it.pashkevich.jd02_01;

public class Runner {
    static int numberBuyer = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 120; i++) {
            Util.sleep(50);
            int count = Util.random(2);
            System.out.println("count="+count);
            for (int j = 1; j <= count; j++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
            }
        }
    }

}
