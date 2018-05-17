package by.it.kovko.calc;

public class BuildFullReport extends BuildReport{
    @Override
    Report buildReport() {
        return Report.getReport(true, "yyyy-MM-dd HH:mm:ss");
    }
}
