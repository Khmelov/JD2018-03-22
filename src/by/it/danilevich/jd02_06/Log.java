package by.it.danilevich.jd02_06;

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


