package by.it.matyuta.jd01;

public class Args {
    private String[] args;

    Args(String[] args){
        this.args = args;
    }

    void printArgs(){
        int i = 1;
        for (String args : args){
            i = i+1;
            System.out.println("Аргумент" + i + "=" + args);
        }
    }
}
