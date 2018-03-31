package by.it.uskoryaev.jd01_01;
class Args {
    private String [] args;

    Args(String [] args){
        this.args = args;
    }

    void printArgs(){
        int i = 1;
        for (String arg : args){
            System.out.println("Аргумент " + i + " = " + arg);
            i++;

        }
    }
}
