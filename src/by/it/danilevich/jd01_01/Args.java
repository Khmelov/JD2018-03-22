package by.it.danilevich.jd01_01;

public class Args {
    //private String[] args;

    /*Args(String[] args){
        this.args = args;
    }*/

    static void printArgs(String[] args){
        int i = 1;
        for (String elem:args) {
            i = i+1;
            System.out.println("Аргумент " + i +" = " + elem);
        }
    }
}
