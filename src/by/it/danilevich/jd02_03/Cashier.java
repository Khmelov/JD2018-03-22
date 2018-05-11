package by.it.danilevich.jd02_03;

public class Cashier implements Runnable {

    private int number;
    private int countServiceByuer=0;
    private double totalMoney;
    Cashier(int number) {
        this.number = number;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public int getCountServiceByuer() {
        return countServiceByuer;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу.");
        //пока план не выполнен, покупатель ищется в очереди
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();
            //покупатель найден
            if (buyer != null) {
                System.out.println(this + ". Начало обслуживания для объекта: " + buyer);
                Util.sleep(Util.random(2000, 5000));
                countServiceByuer++;
                totalMoney = totalMoney + buyer.getTotalMoney();
                System.out.println(this + ". Конец обслуживания  для объекта: " + buyer);
                //покупатель запущен из состояния wait
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(100);
            //тут лучше сделать wait() кассиру на общем для кассиров мониторе,
            //а notify() выполнять на этом же мониторе
            //из метода очереди (после добавления покупателя в очередь)
            //тогда кассир будет начинать работу ровно в тот момент
            //когда эта работа для него появится
            //подумайте, где и почему еще будет нужен notifyAll()
        }
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }
}
