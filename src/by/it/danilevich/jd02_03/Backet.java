package by.it.danilevich.jd02_03;


import java.util.ArrayList;

public class Backet implements IUseBacket {
    private Buyer buyer;
    Backet(Buyer buyer){
        this.buyer = buyer;
    }

    public Buyer getBuyer(){
        return this.buyer;
    }
    @Override
    public void takeBacket() {
        System.out.println(buyer.getNameBuyer() + " взял корзину");
    }

    @Override
    public ArrayList<ArrayList<String>> putGoodsToBacket() {
        int countProduct = Util.random(1, Dispatcher.getMaxProductInBacket());
        Goods goods = new Goods(this);
        return goods.selectGoods(countProduct);
    }


}
