package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
   private static ExtentReports extent;
   public static final String REPORT_FILE_PATH ="./Automation_Reports/";

   public static String dateGenerator()
   {
       DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");
       Date date = new Date();
       return dateFormat.format(date);
   }

   public static void createInstance()
   {
       String path=System.getProperty("user.dir")+REPORT_FILE_PATH;
       ExtentSparkReporter reporter = new ExtentSparkReporter(path+"Test-Automaton-Report"+"_"+dateGenerator()+".html");
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
