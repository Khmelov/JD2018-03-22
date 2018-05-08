package by.it.danilevich.jd02_02;

//import java.util.HashMap;

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

     }
}
