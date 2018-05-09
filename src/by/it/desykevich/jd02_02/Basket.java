package by.it.desykevich.jd02_02;

import java.util.HashMap;
import java.util.Map;

    public class Basket {
        private Map<String, Double> goodsInBasket = new HashMap<>();

        public void addGoodsToBasket(String goodName, Double price) {
            goodsInBasket.put(goodName, price);
        }

        public Map<String, Double> getGoodsInBasket() {
            return goodsInBasket;
        }
    }

