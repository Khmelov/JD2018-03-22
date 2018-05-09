package by.it.danilevich.jd02_02;

import java.util.ArrayList;

public class Cashier extends Thread{
    private ArrayList<Buyer> buyersInCashier = new ArrayList<>();
    private int num;

    Cashier(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Касса №" + num;
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()){
            if (buyersInCashier.size()<5) {
                synchronized (this) {
                    Buyer buyer = Dispatcher.buyersInQueuq.extractByuer();//забрали из общей очереди
                    //покупатель найден и в кассу можно заходить
                    if (buyer != null && Dispatcher.cashiers.get(this) != "block") {
                        Dispatcher.openKass(this);
                        Dispatcher.buyersInQueuq.removeByuer(buyer);
                        System.out.println(this + ". Начало обслуживания для объекта: " + buyer);
                        addBueyr(buyer);//поместили в buyersInCashier чтобы контролировать максимум 5 чел
                        Dispatcher.buyersInKass.addbuyer(buyer);//Общий список покупателей в кассах
                        Util.sleep(Util.random(2000, 5000));
                        System.out.println(this + ". Конец обслуживания  для объекта: " + buyer);
                        removeBueyr(buyer);
                        Dispatcher.buyersInKass.removeByuer(buyer);

                        //покупатель запущен из состояния wait
                        synchronized (buyer) {
                            buyer.notify();
                        }
                    } else
                        try {//остановим кассу потому что в общей очереди нету людей
                            this.wait();
                            Dispatcher.closeKass(this);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    }

    private void addBueyr(Buyer buyer){
        if (buyersInCashier.size()<=Dispatcher.getMaxByerInCashier()) {
            buyersInCashier.add(buyer);
            Dispatcher.buyersInKass.addbuyer(buyer);
            Dispatcher.buyersInQueuq.removeByuer(buyer);
        }
    }

    private void removeBueyr(Buyer buyer){
        buyersInCashier.remove(buyer);
    }

    int getAmountBuyer(){
        return buyersInCashier.size();
    }





}
