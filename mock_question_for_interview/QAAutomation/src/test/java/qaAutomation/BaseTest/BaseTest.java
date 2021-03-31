package qaAutomation.BaseTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import qaAutomation.Constants.Constants;
import qaAutomation.Reporting.ExtentReporting;

/* This class is used for pre and post test action */
public class BaseTest implements Constants {

	static ExtentHtmlReporter extentHtmlReporter;
	static ExtentReports extentReports;
	static ExtentTest extentTest;
	
	/*
	 * @parameters method
	 * 
	 * @returnType void
	 */
	// Method to initiate reporting and start execution
	@BeforeMethod(alwaysRun = true)
	public void startExecution(Method method) {
		// Initializing reporting
		initializeExtentReports();
		// Fetching test case name
		String testCaseName = method.getAnnotation(Test.class).testName();
		// Printing testCase Name on console
		System.out.println("===========================================");
		System.out.println(testCaseName);
		// Add test case name in report
		extentTest = extentReports.createTest(testCaseName);
		String abc = "C:\\Users\\Shibu\\AppData\\Local\\Google\\Chrome\\User Data";
	}

	/*
	 * @parameters NA
	 * 
	 * @returnType void
	 */
	// Method to pass report name
	public void initializeExtentReports() {
		if (ExtentReporting.getInstance() == null) {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
			String formattedDate = simpleDateFormat.format(date);
			extentReports = ExtentReporting.createInstance(
					System.getProperty("user.dir") + "/Reports/" + "ExecutionReport_" + formattedDate + ".html");
		}
	}

	/*
	 * @parameters expectedResult
	 * 
	 * @returnType void
	 */
	// Method for reading from console and reporting
	public static void reporting(String expectedResult) {
		// Create a stream to hold the output
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();    // ByteArrayOutputStream class is used to write common data into multiple files
		PrintStream printStream = new PrintStream(byteArray);   // The PrintStream class provides methods to write data to another stream.
		// Save the old System.out
		PrintStream printStreamOld = System.out;
		// Using old stream
		System.setOut(printStream);
		// Print expectedResult output to old stream
		System.out.println(expectedResult);
		// Putting old stream back in focus
		System.out.flush();
		System.setOut(printStreamOld);
		// Fetching console output
		String actualResult = byteArray.toString().replaceAll(hittingEnter, blankValue).replaceAll(lineChangeCharacter,
				blankValue);
		if (expectedResult.replaceAll(lineChangeCharacter, blankValue).equals(actualResult)) {
			extentTest.log(Status.PASS, actual + actualResult + expected + expectedResult);
		} else {
			extentTest.log(Status.FAIL, actual + actualResult + expected + expectedResult);
		}
	}

	/*
	 * @parameters result
	 * 
	 * @returnType void
	 */
	// Method to display execution completion execution status
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		int result1 = Reporter.getCurrentTestResult().getStatus();
		System.out.println(result1);
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				extentTest.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + executionFailed, ExtentColor.RED));
				// To give reason of failure
				extentTest.fail(result.getThrowable());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + executionPass, ExtentColor.GREEN));
			} else if (result.getStatus() == ITestResult.SKIP) {
				extentTest.log(Status.SKIP,
						MarkupHelper.createLabel(result.getName() + executionSkip, ExtentColor.GREY));
				extentTest.skip(result.getThrowable());
			}
		} catch (Exception e) {
			System.err.println(exception + e.getMessage());
		} finally {
			extentReports.flush();
		}
	}
}
