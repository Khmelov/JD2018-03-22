package by.it.kovko.calc;

public class BuildShortReport extends BuildReport {
    @Override
    Report buildReport() {
        return Report.getReport(false, "yyyy-MM-dd");
    }
}
