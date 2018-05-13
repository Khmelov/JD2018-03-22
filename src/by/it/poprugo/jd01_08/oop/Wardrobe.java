package by.it.poprugo.jd01_08.oop;

abstract class Wardrobe implements Furniture {
    static int w;
    static double p;
    static String nameMaterial = "";

    Wardrobe() {
        w = 80;
        p = 89.9;
        nameMaterial = "laminate";
    }

    abstract void setDim(int width, int high, int depth);

    public static void setNameMaterial(String nameMaterial) {
        Wardrobe.nameMaterial = nameMaterial;
    }

    public static String getNameMaterial() {
        return nameMaterial;
    }

    @Override
    public String color() {
        System.out.println(this + " brown");
        return "brown";
    }

    @Override
    public int weight() {
        System.out.println(this + " weight is " + w + " kg");
        return w;
    }

    @Override
    public double price() {
        System.out.println(this + " costs " + p);
        return p;
    }

    @Override
    public String toString() {
        return "Wardrobe :";
    }
}
