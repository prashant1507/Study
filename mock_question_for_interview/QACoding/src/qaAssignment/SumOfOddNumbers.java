package qaAssignment;

import java.text.NumberFormat;
import java.util.Scanner;

/* This class adds all odd numbers in the range given by user. */
public class SumOfOddNumbers {

	static long startRange, endRange, rangeValue;
	static Scanner userInput;

	public static void main(String[] args) {
		// Scanner class to take input from user
		userInput = new Scanner(System.in);
		// Method call to get and validate start and end range
		startRange = getRange("start range");
		endRange = getRange("end range");
		// Method call to calculate and print the sum
		summationOfOddNumbers(startRange, endRange);
	}

	/*
	 * @parameters rangeType
	 * 
	 * @returnType long
	 */

	// Function to get start and end range value from user and validate it ( by using long data type)
	public static long getRange(String rangeType) {
		try {
			// Accepting range value
			System.out.print("Enter " + rangeType + " (ex: 11, -11): ");
			rangeValue = userInput.nextLong();
			userInput.nextLine();
		} catch (Exception e) {
			System.err.print("Invalid " + rangeType + " " + e + "\n");
			userInput.nextLine();
			getRange(rangeType);
		}
		return rangeValue;
	}

	/*
	 * @parameters start, end
	 * 
	 * @returnType void
	 */

	// Function to calculate sum of odd numbers.
	public static void summationOfOddNumbers(long startRange, long endRange) {
		try {
			long sumOddNumbers = 0;
			long counter = startRange;
			if ( counter <= endRange) {
				// Loop for adding odd numbers when endRange is greater than startRange
				while (counter <= endRange) {
					if (counter % 2 != 0) {
						sumOddNumbers += counter;
					}
					counter++;
				}
			} else {
				// Loop for adding odd numbers when startRange is greater than endRange
				while (counter >= endRange) {
					if (counter % 2 != 0) {
						sumOddNumbers += counter;
					}
					counter--;
				}
			}

			// Formatting of sumOddNumbers separated by commas
			NumberFormat numberFormat = NumberFormat.getInstance();
			numberFormat.setGroupingUsed(true);
			System.out.printf("\nSum of odd numbers between %s to %s is: %s\n\n", startRange, endRange,
					numberFormat.format(sumOddNumbers));

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			userInput.close();
		}
	}
}
