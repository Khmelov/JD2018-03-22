package by.it.danilevich.jd02_01;

public class Runner {
    private static int numberBuyer=0;
    static int countByerShop = 0;
    public static void main(String[] args) {
        int countSec = 120;
        for (int i = 0; i < countSec; i++) {
            int t = i%60;
            Util.sleep(1000);
            if (t<30){
                if (countByerShop >= t + 10) {
                    continue;
                }
            }
            else{
                if (countByerShop > (40 + (30 - t))) {
                    continue;
                }
            }
            int countBuyer = Util.random(2);
            System.out.println("Сейчас зайдет " + countBuyer + " новых покупателей");
            for (int j = 0; j < countBuyer; j++) {
                Boolean pens =false;
                double k = ((double)(numberBuyer+1))%4;
                if (k==0.0){
                    pens = true;
                }
                numberBuyer++;
                Buyer buyer = new Buyer(numberBuyer,pens);
                countByerShop ++;
                System.out.println("Всего покупателей после прихода " + countByerShop);
                buyer.start();
            }
        }
     }
}
