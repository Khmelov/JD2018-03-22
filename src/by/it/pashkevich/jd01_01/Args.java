package by.it.pashkevich.jd01_01;

class Args {
    private String[] args;

    Args (String[] args) {
        this.args = args;
    }

    void printArgs() {
        int i = 1;
        for (String args : args) {
            i = i + 1;
            System.out.println("Аргумент" + i + "=" + args);
        }
    }
}
