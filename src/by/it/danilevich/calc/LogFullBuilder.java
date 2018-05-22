package by.it.danilevich.calc;

/**
 * "ConcreteBuilder"
 */
class LogFullBuilder extends LogBuilder {


    public void buildTitle() {
        log.setTitle("Полный отчет"+Util.getCurrentTime());
    }

    public void buildDescription() {
        if (!this.message.equals("")) {
            log.setDescription(this.date+";"+this.message+";"+this.result);

        } else {
            log.setDescription("Description for full log");
        }
    }
}
