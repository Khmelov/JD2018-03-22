package by.it.poprugo.jd01_08.oop;

public class Bookshelves extends Wardrobe {

    Bookshelves(int wi, double pr, String nM) {
        Wardrobe.w = wi;
        Wardrobe.p = pr;
        Wardrobe.nameMaterial = nM;
    }

    @Override
    void setDim(int width, int high, int depth) {
        System.out.println(this + " dimentions are:\n"
                + "width=" + width + " high=" + high + " depth" + depth);
    }

    @Override
    public String color() {
        int color = 3;
        if (color % 2 == 0) {
            System.out.print(this + " light ");
            super.color();
        } else {
            System.out.print(this + " dark");
            super.color();
        }
        return "";
    }

    public void price(String nameM) {
        switch (nameM) {
            case "wood":
                System.out.println("price: " + this + " 300");
            case "plastic":
                System.out.println("price: " + this + " 200");
            case "glass":
                System.out.println("price: " + this + " 350");
            case "laminate":
                System.out.print("price: " + this);
                super.price();
        }
    }

    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        Wardrobe firstBC = new Bookshelves(125, 350, "wood");
        System.out.print("1) color is a");
        firstBC.color();
        firstBC.setDim(900, 2050, 600);
        firstBC.weight();
        firstBC.price();
        System.out.println("material - " + Wardrobe.nameMaterial);

        Wardrobe secondBC = new Bookshelves(35, 170, "plastic");
        System.out.print("2) color is a");
        secondBC.color();
        secondBC.setDim(450, 1700, 350);
        secondBC.price();
        System.out.println("material - " + Wardrobe.nameMaterial);

        Wardrobe thirdBC = new Bookshelves(170, 260, "glass");
        System.out.print("3) color is a");
        thirdBC.color();
        thirdBC.setDim(300, 1250, 260);
        thirdBC.price();
        System.out.println("material - " + Wardrobe.nameMaterial);
    }
}
