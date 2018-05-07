package by.it.fando.jd02_01;

public class Runner {
    static int numberBuyer = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 120; i++) {
            Util.sleep(50);
            int n = 3;
            int count = Util.random(2);
            for (int j = 0; j < count ; j++) {
                System.out.println("count=" + count);
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
            }
        }
    }
}
