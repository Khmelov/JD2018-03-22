package by.it.danilevich.calc;

class Log {
    private String title = "";
    private String description = "";
    private String result = "";
    private static Log instance;
    void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}


