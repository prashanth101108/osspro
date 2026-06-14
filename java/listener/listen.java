package listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import commonpack.commonclss;

public class listen implements ITestListener{
	
	
	  ExtentReports extent;
	    ExtentTest test;

	    // ✅ Before Suite Starts
	    @Override
	    public void onStart(ITestContext context) {

	        String path = "C:\\Users\\2035\\eclipse-workspace\\osss\\extent report\\index.html";

	        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	        reporter.config().setReportName("Automation Report");
	        reporter.config().setDocumentTitle("Execution Report");

	        extent = new ExtentReports();
	        extent.attachReporter(reporter);

	        extent.setSystemInfo("Tester", "Prashanth");
	        extent.setSystemInfo("Environment", "QA");
	    }

	    // ✅ Test Start
	    @Override
	    public void onTestStart(ITestResult result) {

	        test = extent.createTest(result.getMethod().getMethodName());
	        test.info("Test Started");
	    }

	    // ✅ Test Pass
	    @Override
	    public void onTestSuccess(ITestResult result) {

	        test.pass("Test Passed");
	    }

	    // ✅ Test Failure + Screenshot
	    @Override
	    public void onTestFailure(ITestResult result) {

	        test.fail(result.getThrowable());

	        WebDriver driver = commonclss.driver;

	        String path = System.getProperty("user.dir")
	                + "/reports/"
	                + result.getMethod().getMethodName()
	                + ".png";

	        File src = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.FILE);

	        File dest = new File(path);

	        try {
	            FileUtils.copyFile(src, dest);
	            test.addScreenCaptureFromPath(path);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // ✅ Test Skipped
	    @Override
	    public void onTestSkipped(ITestResult result) {

	        test.skip("Test Skipped");
	    }

	    // ✅ After Suite Finish
	    @Override
	    public void onFinish(ITestContext context) {

	        extent.flush(); // VERY IMPORTANT
	    }
	}
	
