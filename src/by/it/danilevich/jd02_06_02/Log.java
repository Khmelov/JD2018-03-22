package by.it.danilevich.jd02_06_02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Log {
    private String title = "";
    private String description = "";
    private String result = "";
    private static Log instance;
    void setTitle(String title) {
        this.title = title;
    }

    void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}


