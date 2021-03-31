package qaAutomation.Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/* This class is to create and return instance of ExtentReports */
public class ExtentReporting {
	static ExtentHtmlReporter extentHtmlReporter;
	static ExtentReports extentReports;

	/*
	 * @parameters NA
	 * 
	 * @returnType ExtentReports
	 */
	public static ExtentReports getInstance() { 
		return extentReports;		
	}
	
	/*
	 * @parameters fileName
	 * 
	 * @returnType ExtentReports
	 */
	public static ExtentReports createInstance(String fileName) {
		// To generate report with name
		extentHtmlReporter = new ExtentHtmlReporter(fileName);
		// Setting Document Title
		extentHtmlReporter.config().setDocumentTitle("QA Testing");
		// Setting Report Name
		extentHtmlReporter.config().setReportName("QA Challange");
		// Setting Theme
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
		// Setting Chart location
		extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		// Setting Chart visibility
		extentHtmlReporter.config().setChartVisibilityOnOpen(false);
		// Setting Time stamp
		extentHtmlReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
		// Setting append exist as true
		extentHtmlReporter.setAppendExisting(true);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		// Setting system info
		extentReports.setSystemInfo("Name", "Prashant Jeet Singh");

		return extentReports;
	}
}

