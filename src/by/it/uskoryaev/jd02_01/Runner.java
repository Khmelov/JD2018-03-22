package by.it.uskoryaev.jd02_01;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i <120 ; i++) {
            Util.sleep(50);
            int count = Util.random();
            System.out.println("count="+ count);
            for (int j = 0; j <count ; j++) {
                int numberBuyer = 0;
                Buyer buyer = new Buyer(numberBuyer);
                buyer.start();
            }

        }
    }

}
