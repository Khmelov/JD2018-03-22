package by.it.volchek.jd02_02;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volchek on 26.04.18.
 */
public class Runner {
    List<Cashier> cashiers = new ArrayList<>();
    static String fout = getPath (Runner.class,"Result.txt");
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <=5 ; i++) {
            new Thread(new Cashier(i)).start();
        }
        Goods.fillStoreWithGoods();
        long start = System.nanoTime();
        long delta=System.nanoTime();
        try (PrintWriter pr = new PrintWriter(new FileWriter(fout)))
        {
        while (!Dispatcher.allBuyersInShop()) { //10 секунд
            Util.sleep(500);
            //if (Thread.activeCount()>35) {Util.sleep(100);}
            int count = Util.random((int)(1+10*Math.abs(Math.sin((delta-start)/3.0e10*Math.PI/2))));
            for (int j = 0; j <=count; j++) {
                Buyer buyer = Dispatcher.addNewBuyer();
                buyer.start();
                delta=System.nanoTime();
                        pr.print(Thread.activeCount()+" "+(delta-start)/1.0e9+" sec"+"\n");

            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;

    }
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;

    }


}
