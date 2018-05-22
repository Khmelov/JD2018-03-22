package by.it.danilevich.jd02_06_02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class PrintFile {
    private LogBuilder logBuilder;
    private static PrintFile instance;
    private PrintWriter printWriter;
    void setLogBuilder(LogBuilder lb) {
        logBuilder = lb;
    }

    Log getLogger() {
        return logBuilder.getLog();
    }

    void constructLogger() throws IOException {
        logBuilder.createNewWriteToFile();
        logBuilder.buildTitle();
        logBuilder.buildDescription();
    }

    private PrintFile() throws IOException {
        String fileName = Util.getPath(Log.class, "log.txt");
        printWriter = new PrintWriter(new FileWriter(fileName), true);
    }

    static PrintFile getInstance() throws IOException {
        if (instance == null) {
            synchronized (PrintFile.class) {
                if (instance == null)
                    instance = new PrintFile();
            }
        }
        return instance;
    }

    public void toLog(String s){
        if (instance!=null) this.printWriter.println(s);
    }



}
