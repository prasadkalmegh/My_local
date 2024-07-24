package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

  public static ExtentReports ExtentReporting() {
	  
		String path = System.getProperty("user.dir")+ "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Test Reports");
        reporter.config().setReportName("Automation test report");
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Prasad k");
        
        return extent;
        
        
        
  }	
	
}
