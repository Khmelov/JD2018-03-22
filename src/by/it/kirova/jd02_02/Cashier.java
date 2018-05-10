package by.it.kirova.jd02_02;

public class Cashier implements Runnable {

    public boolean isOpen() {
        return isOpen;
    }

    public synchronized void openCashier() {
        if(!isOpen){
            isOpen = true;
            System.out.println("\u001B[36m" + this + " открыл кассу.\u001B[0m");
            this.notify();
        }
    }

    private synchronized void closeCashier(){
        if(isOpen){
            isOpen = false;
            if(count != -1){
                totalCount += count;
                System.out.println("\u001B[31m" + this + " закрыл кассу обработав "+ count +" человек.\u001B[0m");
            }
            count = 0;
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int number;
    private boolean isOpen = true;
    private int count = -1;
    private int totalCount = 0;

    public double getTotalCost() {
        return totalCost;
    }

    private double totalCost = 0;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        //пока план не выполнен, покупатель ищется в очереди
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();
            //покупатель найден
            if (buyer != null) {
                //openCashier();
                processBuyer(buyer);
            } else{
                closeCashier();
            }

            //тут лучше сделать wait() кассиру на общем для кассиров мониторе,
            //а notify() выполнять на этом же мониторе
            //из метода очереди (после добавления покупателя в очередь)
            //тогда кассир будет начинать работу ровно в тот момент
            //когда эта работа для него появится
            //подумайте, где и почему еще будет нужен notifyAll()
        }
        System.out.println("Кассир " + number +
                " завершил рабочий день обработав " + totalCount + " человек.");
    }

    private void processBuyer(Buyer buyer){
        System.out.println(this + ". Начало обслуживания для " + buyer);
        Util.sleep(Util.random(2000, 5000));
        totalCost += Printer.printCheck(buyer.getBacket(), buyer.toString(), this.toString());
        System.out.println(this + ". Конец обслуживания для " + buyer);
        //покупатель запущен из состояния wait
        synchronized (buyer) {
            buyer.notify();
        }
        count++;
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }


}
