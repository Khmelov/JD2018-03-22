package by.it.lyukovich.MicrosoftEdx.Edx_003;

public class DataTypes {
    public static double x=100;
    public static final int y=150;
    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(y);
        myData();
    }
    public static void myData(){
        int z=7;
        z/=6.5;
        x = 12/y;
        System.out.println(x);
        System.out.println(z);
    }

}
