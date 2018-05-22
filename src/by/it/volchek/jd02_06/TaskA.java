package by.it.volchek.jd02_06;

/**
 * Created by volchek on 15.05.18.
 */
public class TaskA {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        for (int i = 0; i < 10; i++) {


            logger.toLog("Привет #" + i);
        }
    }
}
