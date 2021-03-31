package qaAutomation.testsuite;

import org.testng.annotations.Test;
import qaAutomation.Constants.Constants;
import qaAutomation.code.SumOfOddNumbers;

/* This class implements validation of sum of odd numbers between given range */
public class SumOfOddNumbersTestSuite extends SumOfOddNumbers implements Constants {
	  
	/*
	 * @Objective: Sum of odd numbers is displayed for the given range
	 * @Test Name: To verify if the user is able to see the sum of odd numbers for the given range for numeric whole numbers.
	 * @Author: Prashant Jeet Singh
	 * @Date: 26/6/2018
	 * @Test Data: </QAAutomation/src/test/resources/qaAutomation/TestData/testData.yaml>
	 */
	@Test(testName="To verify if the user is able to see the sum of odd numbers for the given range for numeric whole numbers.")
	public void verificationOfSumOfOddNumbers () {
		// Method to find and verify sum of all odd numbers
		SumOfOddNumbers.summationOfOddNumbers(positiveScenario);
		
	}
	
	/*
	 * @Objective: An Error message is displayed for range values other than the whole number.
	 * @Test Name: To verify error message if the user enters a non-numeric value in starting range.
	 * @Author: Prashant Jeet Singh
	 * @Date: 26/6/2018
	 * @Test Data: </QAAutomation/src/test/resources/qaAutomation/TestData/testData.yaml>
	 */
	@Test(testName="To verify error message if the user enters a non-numeric value in starting range.")
	public void verificationOfErrorMessageForNonNumericStartRange () {
		// Method to find and verify sum of all odd numbers for non-numeric start range
		SumOfOddNumbers.summationOfOddNumbers(nonNumericStartRange);
		
	}
	
	/*
	 * @Objective: An Error message is displayed for range values other than the whole number.
	 * @Test Name: To verify error message if the user enters a non-numeric value in ending range.
	 * @Author: Prashant Jeet Singh
	 * @Date: 26/6/2018
	 * @Test Data: </QAAutomation/src/test/resources/qaAutomation/TestData/testData.yaml>
	 */
	@Test(testName="To verify error message if the user enters a non-numeric value in ending range.")
	public void verificationOfErrorMessageForNonNumericEndRange () {
		// Method to find and verify sum of all odd numbers for non-numeric end range
		SumOfOddNumbers.summationOfOddNumbers(nonNumericEndRange);
		
	}
	
	/*
	 * @Objective: Sum of odd numbers is displayed for the given negative range
	 * @Test Name: To verify if the user is able to see the sum of odd numbers for the given range having negative start and end range.
	 * @Author: Prashant Jeet Singh
	 * @Date: 26/6/2018
	 * @Test Data: </QAAutomation/src/test/resources/qaAutomation/TestData/testData.yaml>
	 */
	@Test(testName="To verify if the user is able to see the sum of odd numbers for the given range having negative start and end range.")
	public void verificationOfSumOfOddNumbersForNegativeRanges () {
		// Method to find and verify sum of all odd numbers for decimal end range
		SumOfOddNumbers.summationOfOddNumbers(negativeRange);
		
	}
	
	/*
	 * @Objective: Sum of odd numbers is displayed for the given negative range
	 * @Test Name: To verify if the user is able to see the sum of odd numbers for the given range having negative start range.
	 * @Author: Prashant Jeet Singh
	 * @Date: 26/6/2018
	 * @Test Data: </QAAutomation/src/test/resources/qaAutomation/TestData/testData.yaml>
	 */
	@Test(testName="To verify if the user is able to see the sum of odd numbers for the given range having negative start range.")
	public void verificationOfSumOfOddNumbersForNegativeStartRange () {
		// Method to find and verify sum of all odd numbers for decimal start range
		SumOfOddNumbers.summationOfOddNumbers(negativeStartRange);
		
	}
	/*
	 * @Objective: Sum of odd numbers is displayed for the given negative range
	 * @Test Name: To verify if the user is able to see the sum of odd numbers for the given range having negative end range.
	 * @Author: Prashant Jeet Singh
	 * @Date: 26/6/2018
	 * @Test Data: </QAAutomation/src/test/resources/qaAutomation/TestData/testData.yaml>
	 */
	@Test(testName="To verify if the user is able to see the sum of odd numbers for the given range having negative end range.")
	public void verificationOfSumOfOddNumbersForNegativeEndRange () {
		// Method to find and verify sum of all odd numbers for decimal end range
		SumOfOddNumbers.summationOfOddNumbers(negativeEndRange);
		
	}
}
