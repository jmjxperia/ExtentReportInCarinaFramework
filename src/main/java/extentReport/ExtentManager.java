package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
   private static ExtentReports extent;
   public static final String REPORT_FILE_PATH ="./Automation_Reports/";

   public static void createInstance()
   {
       String path=System.getProperty("user.dir")+REPORT_FILE_PATH;
       ExtentSparkReporter reporter = new ExtentSparkReporter(path+"Test-Automaton-Report"+"_"+".html");
       reporter.config().setReportName("Automation Results");
       reporter.config().setDocumentTitle("Test Results");
       //reporter.config().setTheme(Theme.DARK);
       extent=new ExtentReports();
       extent.attachReporter(reporter);
       extent.setSystemInfo("Tester","Jathin");
       extent.setSystemInfo("OS",  System.getProperty("os.name"));
       extent.setSystemInfo("Java",  System.getProperty("java.specification.version"));
   }

   public static ExtentReports getInstance() {
       if (extent == null)
           createInstance();
       return extent;
   }

}
