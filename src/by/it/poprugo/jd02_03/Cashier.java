package by.it.poprugo.jd02_03;

public class Cashier implements Runnable {
    private int number;

    public Cashier(int number) { this.number = number; }

    @Override
    public void run() {
        while (!Dispatcher.planCompete()) { // пока в магазине есть/остаётся хоть один покупатель
            Buyer buyer = QueueBuyer.extractBuyer(); //покупатель найден; засинхронизировалось по очереди
            if (buyer != null) {
                System.out.println(this + "начало обслуживния " + buyer);
                Util.sleep(Util.random(2000, 5000));
                System.out.println(this + "завершил обслуживане" + buyer);
                //покупатель запущен из состояния wait
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(100); // лучше wait(),  а не sleep:
            //тут лучше сделать wait() кассиру на общем для кассиров мониторе,
            //а notify() выполнять на этом же мониторе
            //из метода очереди (после добавления покупателя в очередь)
            //тогда кассир будет начинать работу ровно в тот момент
            //когда эта работа для него появится
            //подумайте, где и почему еще будет нужен notifyAll()
        }
        System.out.println(this + " закрыл кассу");

    }

    @Override
    public String toString() {
        return "Cashier #" + number + " ";
    }
}
