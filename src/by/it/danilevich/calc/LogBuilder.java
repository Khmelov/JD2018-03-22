package by.it.danilevich.calc;

/**
 * "Abstract Builder"
 */
abstract class LogBuilder {
    Log log;

    Log getLog() {
        return log;
    }

    protected String message;
    protected String date;
    protected String result;
    protected Boolean errors;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrors(Boolean errors) {
        this.errors = errors;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setResult(String result) {
        this.result = result;
    }

    void createNewWriteToFile() {
        log = new Log();
    }

    public abstract void buildTitle();

    public abstract void buildDescription();
}

