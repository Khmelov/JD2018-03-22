package by.it.danilevich.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;

class Goods {
    private HashMap<String, Double> product = new HashMap<>();
    private HashMap<Integer, String> indexProduct = new HashMap<>();
    private Backet backet;
    Goods(Backet backet){
        product.put("milk", 1.36);
        product.put("bread", 1.7);
        product.put("meat", 7.8);
        product.put("tea", 1.36);
        product.put("chocolate", 1.36);
        product.put("cheese", 1.36);
        product.put("apple", 1.36);
        indexProduct.put(1, "milk");
        indexProduct.put(2, "bread");
        indexProduct.put(3, "meat");
        indexProduct.put(4, "tea");
        indexProduct.put(5, "chocolate");
        indexProduct.put(6, "cheese");
        indexProduct.put(7, "apple");

         this.backet = backet;
    }

    void selectGoods(int countProduct){
        ArrayList<ArrayList<String>> selectProduct = new ArrayList<>();

        for (int i = 1; i <= countProduct; i++) {
            int num = Util.random(1, this.product.size());
            String productS = indexProduct.get(num);
            String price = product.get(productS).toString();
            ArrayList<String> struct = new ArrayList<>();
            struct.add(productS);
            struct.add(price);
            selectProduct.add(struct);
        }
        printSelectedProduct(selectProduct);

    }
    private void printSelectedProduct(ArrayList<ArrayList<String>> selectProduct){
        double sum = 0;
        String listProd = backet.getBuyer().getNameBuyer()+" выбрал "+ selectProduct.size() +" товар ";
        for (ArrayList<String> tov: selectProduct ) {
            listProd = listProd.concat(tov.get(0))+":"+tov.get(1)+"|";
            sum = sum+ Double.valueOf(tov.get(1));
        }
        System.out.println(listProd + "Итого: "+sum);
      }
}
