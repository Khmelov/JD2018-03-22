package by.it.volchek.jd01_01;

import java.util.*;

/**
 * Created by volchek on 22.03.18.
 */
class Args {
    private String[] args;

    Args(String[] args) {
        this.args = args;
    }

    void printObj() {
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + args[i]);
        }
    }
}
