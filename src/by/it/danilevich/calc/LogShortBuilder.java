package by.it.danilevich.calc;

/**
 * "ConcreteBuilder"
 */
class LogShortBuilder extends LogBuilder {


   public void buildTitle() {
        log.setTitle("Краткий отчет"+Util.getCurrentTime());
    }

    public void buildDescription() {

        if (!this.message.equals("")) {
            if (this.errors){
                log.setDescription(this.date+";"+this.result);
            }
            else log.setDescription(this.date+";"+this.message+";"+this.result);
        } else {
            log.setDescription("short description");
        }
    }




}
