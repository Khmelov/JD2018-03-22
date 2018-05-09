package by.it.danilevich.jd02_02;

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
    public void putGoodsToBacket() {
        int countProduct = Util.random(1,4);
        Goods goods = new Goods(this);
        goods.selectGoods(countProduct);
    }


}
