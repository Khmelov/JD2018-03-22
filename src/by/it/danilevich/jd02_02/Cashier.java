package by.it.danilevich.jd02_02;

import java.util.ArrayList;

public class Cashier implements Runnable{
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
                Buyer buyer;
                synchronized (Dispatcher.buyersInQueuq) {
                    //чтобы другая касса не взяла
                    buyer = Dispatcher.buyersInQueuq.extractByuer();//забрали из общей очереди

                    //покупатель найден и в кассу можно заходить
                    if (buyer != null && Dispatcher.cashiers.get(this) != "block") {
                        //
                        Dispatcher.openKass(this);
                        Util.sleep(1);
                        addBueyrToKass(buyer);//поместили в buyersInCashier чтобы контролировать максимум 5 чел
                        printByer();
                        System.out.println(this + ". Начало обслуживания для объекта: " + buyer);

                        Dispatcher.buyersInKass.addbuyer(buyer);//Общий список покупателей в кассах
                        Util.sleep(Util.random(2000, 5000));
                        System.out.println(this + ". Конец обслуживания  для объекта: " + buyer);
                        Dispatcher.buyerKass.put(buyer, this);
                        removeBueyrFromKass(buyer);
                        Dispatcher.buyersInKass.removeByuer(buyer);

                        //покупатель запущен из состояния wait
                        synchronized (buyer) {
                            buyer.notify();
                        }

                    } else Util.sleep(1000);
                    // не разобралась откуда заморозить
                        /*try {//остановим кассу потому что в общей очереди нету людей
                            this.wait();
                            Dispatcher.closeKass(this);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                }
            }

        }
    }

    private void addBueyrToKass(Buyer buyer){
        synchronized (buyersInCashier){
            if (buyersInCashier.size()<=Dispatcher.getMaxByerInCashier()) {
                buyersInCashier.add(buyer);
                Dispatcher.buyersInKass.addbuyer(buyer);
                Dispatcher.buyersInQueuq.removeByuer(buyer);
            }
        }


    }

    private void removeBueyrFromKass(Buyer buyer){
        synchronized (buyersInCashier) {
            buyersInCashier.remove(buyer);
        }
    }

    /*int getAmountBuyer(){
        return buyersInCashier.size();
    }*/

    private void printByer(){
        String linePrint = "Касса №" + num +": ";
        for (Buyer buyer:buyersInCashier){
            linePrint = linePrint.concat(buyer.getNameBuyer()) +"|";
        }
        System.out.println(linePrint);

    }




}
