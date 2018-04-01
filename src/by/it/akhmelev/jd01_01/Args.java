package by.it.akhmelev.jd01_01;

class Args {

    private String[] args;

    Args(String[] args) {
        this.args = args;
    }

    void print(){
        for (int i = 0; i < args.length; i++) {
            System.out.println(i+args[i]);
        }

    }
}
