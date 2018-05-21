package by.it.danilevich.jd02_06_02;

/**
 * "ConcreteBuilder"
 */
class LogFullBuilder extends LogBuilder {


    public void buildTitle() {
        log.setTitle("Log Full");
    }

    public void buildDescription() {
        if (!this.message.equals("")) {
            log.setDescription(this.date+";"+this.message+";"+this.result);

        } else {
            log.setDescription("Description for full log");
        }
    }
}
