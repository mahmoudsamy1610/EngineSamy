package Automation.engine;

public class GenerateAllureReport {

    static String AllureResultPath = GetProperty.GetPropertyValue("allure","AllureResultDirectory");
    static  String AllureReportLPath = GetProperty.GetPropertyValue("allure","AllureReportDirectory");
    static String  AllureGenerateCommand = "allure generate " + AllureResultPath + " --clean -o " + AllureReportLPath ;



    public static void GenerateAllureReport() {
        try {
            CMDRunner.runCommand(AllureGenerateCommand);
            System.out.println("Test Run is Done and, Allure Report Generated successfully to " + AllureResultPath  + ", Check HTML file in " + AllureReportLPath );


    } catch (Exception e) {
            e.getMessage();
            System.out.println("an Error occurred while parsing CMD command from properties");}
        }

}
