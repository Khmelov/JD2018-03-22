package by.it.danilevich.jd02_06_02;

import java.io.IOException;

public class TaskA {
    public static void main(String[] args) throws IOException {
        Logger logger = null;
        logger = Logger.getLogger();
        for (int i = 0; i < 10; i++) {
            logger.toLog(String.valueOf(i));
        }
    }



}
