package by.it.volchek.jd02_02;

/**
 * Created by volchek on 05.05.18.
 */
public class Cashier implements Runnable {
    public Cashier(int number ) {

    }

    @Override
    public String toString() {
        return "Cashier №"+number +" ";
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();
            System.out.println(this + " начало обслуживания"+ buyer);
            Util.sleep(Util.random(2000,5000));
            System.out.println(this + " завершил обслуживание"+ buyer);

        }

    }
}
