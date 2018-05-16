package by.it.sgolovach.jd02_06.calc;

public abstract class ReportBuilder {

    Report report;

    void creatReport(){
        report=new Report();
    }

    abstract void creatFileLog();

    abstract void headReport();

    abstract void startPackage();

    abstract void errorPackage();

    abstract void finishPacage();

    Report getReport(){
        return report;
    }
}
