package fontexplorerx.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        //htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
        htmlReporter = new ExtentHtmlReporter("/Users/fexuser/IdeaProjects/FontExplorerX.com/ExtentReport/" + "MyReport.html");
       // htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        htmlReporter.loadXMLConfig("/Users/fexuser/IdeaProjects/FontExplorerX.com" + "/extent-config.xml");
        //htmlReporter.config().setDocumentTitle("Automation Test Report");
        //htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "FontExplorerX.com");
        extent.setSystemInfo("Tester", "Ankita Gupta");
        extent.setSystemInfo("OS", "MAC BigSur");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void endReport() {
        extent.flush();
    }
}
