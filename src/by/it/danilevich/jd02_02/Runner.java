package by.it.danilevich.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Runner {

     public static void main(String[] args) {
        Dispatcher.createKass();

        /*int countSec = 5;
        for (int i = 0; i < countSec; i++) {
            int t = i%60;
            Util.sleep(1000);
            if (t<30){
                if (Dispatcher.getFactProcess()>=t+10){
                    continue;
                   }
            }
            else{
                if(Dispatcher.getFactProcess()>(40+(30-t))){
                    continue;
                }

            }
            }*/

            Dispatcher.createBuer();
         //ожидаем закрытия последней кассы
        for (Map.Entry<Cashier, Thread> s:Dispatcher.cashiersThread.entrySet()) {
             try {
                 s.getValue().join();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }

         //отдаем управление потоком для завершения выводов покупателей
         Thread.yield();
         System.out.println("Магазин закрылся");

         for (Map.Entry ent : Dispatcher.cashiers.entrySet()) {
             Cashier cashier = (Cashier) ent.getKey();
             System.out.print(String.format("|%20s|", cashier.toString()));
         }
         System.out.println();
         HashMap<Buyer,Cashier> buyerKass = Dispatcher.buyerKass;
         while (buyerKass.size()!=0){
             for (Map.Entry ent : Dispatcher.cashiers.entrySet()) {
                 Cashier cashier = (Cashier) ent.getKey();
                 int find = 0;

                 for (Map.Entry entry : buyerKass.entrySet()) {
                     Buyer buyer = (Buyer) entry.getKey();
                     Cashier cashier1 = (Cashier) entry.getValue();
                     if (cashier.equals(cashier1)) {
                         find = 1;
                         System.out.print(String.format("|%20s|", buyer.getNameBuyer() + ": " + buyer.getTotalMoney()));
                         buyerKass.remove(entry.getKey());
                         break;
                     }
                 }
                 if (find == 0) System.out.print(String.format("|%20s|","----"));
             }
             System.out.println();
         }
     }
}
