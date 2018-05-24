package by.it.danilevich.jd02_06;

/**
 * "ConcreteBuilder"
 */
class LogShortBuilder extends LogBuilder {


   public void buildTitle() {
        log.setTitle("Log short");
    }

    public void buildDescription() {

        if (!this.message.equals("")) {
            if (this.errors){
                log.setDescription(this.date+";"+this.message+";"+this.result);
            }
            else log.setDescription(this.date+";"+this.message+";"+this.result);
        } else {
            log.setDescription("short description");
        }
    }




}
