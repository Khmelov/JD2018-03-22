package by.it.shekh.jd01_01;

public class Args {

    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    void print(){

        int i=0;
        for(String arg: args){
            i++;
            System.out.println("Arg: "+i+"="+arg);

        }
    }
}
