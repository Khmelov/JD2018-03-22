package by.it.desykevich.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private String name;
    private Basket basket;

    public Buyer(int number) {
        name = "Покупатель №" + number;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    public Basket getBasket() {
        return basket;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void takeBasket() {
        Util.sleep(100, 200);
        System.out.println(this + "взял корзину.");
    }


    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Util.random(5); i++) {
            Util.sleep(500, 2000);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + "выбрал товар " + goodName + " цена: " + goodPrice + ".");
        }
        System.out.println(this + "завершил выбор.");
    }

    @Override
    public void putGoodsToBasket(String name, Double price) {
        System.out.println(this + " положил " + name + " за " + price + " рублей в корзину.");
        basket.addGoodsToBasket(name, price);
        Util.sleep(100, 200);
    }

    @Override
    public void goQueue() {
        System.out.println(this + "встал в очередь");
        QueueBuyer.addBuyer(this);
        synchronized (this) {
            while (QueueBuyer.buyerInQueue(this))
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Dispatcher.incNumOfServedCustomers();
        Dispatcher.finalBuyer();
    }

}
