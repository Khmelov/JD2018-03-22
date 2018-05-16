package by.it.kovko.calc;

public class ReportFactory {
    static Report createReport(){
        BuildReport build;
        if (Math.random()<0.5)
            build = new BuildFullReport();
        else
            build = new BuildShortReport();
        return build.buildReport();
    }

}
