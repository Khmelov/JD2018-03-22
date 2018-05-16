package by.it.sgolovach.jd02_06.calc;

public class Director {

    ReportBuilder reportBuilder;


    void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    Report getReport() {
        return reportBuilder.getReport();
    }

    void buildReport() {
        reportBuilder.creatReport();
        reportBuilder.creatFileLog();
        reportBuilder.headReport();
        reportBuilder.startPackage();
    }

    void errorReport(){
        reportBuilder.errorPackage();

    }

    void finishReport(){
        reportBuilder.finishPacage();
    }


}
