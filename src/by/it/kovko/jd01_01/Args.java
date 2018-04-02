package by.it.kovko.jd01_01;

/**
 * Мой класс
 */
public class Args {
    private String Args[];
    Args(String[] args){
        this.Args=args;
    }


    /**
     * Method for printing command line arguments
     */
    void printArgs(){
        int i=0;
        if (Args.length==0){
            System.out.println("Программа не содержит аргументов командной строки");
        } else {
            for (String arg : Args) {
                System.out.println("Аргумент "+ ++i + " = " + arg);
            }
        }
    }
    static void printArgs(String[] Args){
        int i=0;
        if (Args.length==0){
            System.out.println("Программа не содержит аргументов командной строки");
        } else {
            for (String arg : Args) {
                System.out.println("Аргумент "+ ++i + " = " + arg);
            }
        }
    }
}
