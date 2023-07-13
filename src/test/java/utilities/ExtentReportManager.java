package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
    String repName;
	
    public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp+ ".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report
		
		sparkReporter.config().setDocumentTitle("ParaBank Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("ParaBank Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Parabank");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub Module", "Customers");	
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
		extent.setSystemInfo("Environment","QA");			
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable().getMessage()); 
		try {
			String imgPath= new BaseClass().captureScreen(result.getName());
		    test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1) {
			e1.printStackTrace();

		}
		
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case SKIPPED");
		test.log(Status.SKIP,result.getThrowable().getMessage());
		
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
		
	
}

