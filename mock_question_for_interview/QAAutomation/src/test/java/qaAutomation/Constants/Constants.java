package qaAutomation.Constants;

/* This interface implements all the constants used in framework to avoid hard coding */
public interface Constants {

	String fileYAML = System.getProperty("user.dir") + "/src/test/resources/qaAutomation/TestData/testData.yaml";

	// YAML COnstants
	String positiveScenario = "Positive Scenario";
	String nonNumericStartRange = "NonNumeric Start Range";
	String nonNumericEndRange = "NonNumeric End Range";
	String negativeRange = "Negative Range";
	String negativeStartRange = "Negative Start Range";
	String negativeEndRange = "Negative End Range";
	String startingRange = "Start Range";
	String endingRange = "End Range";
	
	// Constants
	String blankValue = "";
	String lineChangeCharacter = "\n";
	String hittingEnter = "\r";
	String actual = "<b>Actual: </b>";
	String expected = "<br><b>Expected: </b>";
	String executionFailed = " - <b>Execution Failed</b>";
	String executionPass = " - <b>Execution Pass</b>";
	String executionSkip = " - <b>Execution Skipped</b>";
	String exception = "Exception: ";
	String invalid = "Invalid ";
	String space = " ";
	String enter = "Enter ";
	String example = " (ex: 11, -11): ";
	String sumOfOdd = "Sum of odd numbers between ";
	String to = " to ";
	String is = " is: ";
	String formatSpecifierS = "%s";
}

