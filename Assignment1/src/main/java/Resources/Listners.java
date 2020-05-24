package Resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listners extends DriverFactory implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtendReportNG.getReport();
	ThreadLocal<ExtentReports> extentTest = new ThreadLocal<ExtentReports>();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		test.fail(result.getThrowable());
		WebDriver driver = null;
		String failMethodname = result.getMethod().getMethodName();
		log.info("Test failed for "+failMethodname);
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		try {
			test.addScreenCaptureFromPath(Takescreenshot(failMethodname, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Test execution starting");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
