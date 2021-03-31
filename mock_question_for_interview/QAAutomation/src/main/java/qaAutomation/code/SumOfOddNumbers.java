package qaAutomation.code;

import java.io.FileReader;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import qaAutomation.BaseTest.BaseTest;
import qaAutomation.Constants.Constants;

/* This class adds all odd numbers in the range given by user. */

public class SumOfOddNumbers extends BaseTest implements Constants {

	static long startRange, endRange, rangeValue;
	// static Scanner userInput;
	static int index;
	static String yamlData;

	public static void summationOfOddNumbers(String yamlParentName) {
		// Scanner class to take input from user
		// userInput = new Scanner(System.in);
		yamlData = yamlParentName;
		index = -1;
		startRange = getRange(startingRange);
		endRange = getRange(endingRange);
		summationOfOddNumbers(startRange, endRange);
	}

	/*
	 * @parameters rangeType
	 * 
	 * @returnType long
	 */

	// Function to get start and end range value from user
	public static long getRange(String rangeType) {
		try {
			// Accepting range from yaml data
			index++;
			System.out.print(enter + rangeType + example);
			// Reporting
			reporting(enter + rangeType + example);
			rangeValue = readDataFromYAML(yamlData, rangeType, index);
			System.out.println(rangeValue);
			// Reporting
			reporting(blankValue + rangeValue);
			// rangeValue = userInput.nextLong();
			// userInput.nextLine();
		} catch (Exception e) {
			System.err.print(invalid + rangeType + space + e + lineChangeCharacter);
			// Reporting
			reporting(invalid + rangeType + space + e + lineChangeCharacter);
			// userInput.nextLine();
			getRange(rangeType);
		}
		return rangeValue;
	}

	/*
	 * @parameters start, end
	 * 
	 * @returnType void
	 */

	// Function to validate user input and then call function to calculate sum of
	// odd numbers.
	public static void summationOfOddNumbers(long startRange, long endRange) {
		try {
			long sumOddNumbers = 0;
			long counter = startRange;
			if (counter <= endRange) {
				// Loop for adding odd numbers when endRange is greater than endRange
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
			System.out.printf(
					lineChangeCharacter + sumOfOdd + formatSpecifierS + to + formatSpecifierS + is + formatSpecifierS
							+ lineChangeCharacter + lineChangeCharacter,
					startRange, endRange, numberFormat.format(sumOddNumbers));
			// Reporting
			reporting(lineChangeCharacter + sumOfOdd + startRange + to + endRange + is
					+ numberFormat.format(sumOddNumbers) + lineChangeCharacter + lineChangeCharacter);

		} catch (Exception e) {
			System.err.println(exception + e.getMessage());
			// Reporting
			reporting(exception + e.getMessage());
		} finally {
			// userInput.close();
		}
	}

	// Adding below method for testing
	// Reading start and end range from YAML
	public static long readDataFromYAML(String parentYamlNode, String range, int index) {
		List<Map<String, Object>> yamlKey = null;
		try {
			final String fileName = fileYAML;
			Map<String, Object> yamlMaps;
			Yaml yaml = new Yaml();
			// Fetching all data from yaml id
			yamlMaps = (Map<String, Object>) yaml.load(new FileReader(fileName));
			// Fetching sub yaml keys from yamlMaps
			yamlKey = (List<Map<String, Object>>) yamlMaps.get(parentYamlNode);
			// Fetching Range from yamlKey
			rangeValue = Long.parseLong(yamlKey.get(index).get(range).toString());
		} catch (Exception e) {
			System.out.println(yamlKey.get(index).get(range).toString());
			reporting(yamlKey.get(index).get(range).toString());
			System.err.print(lineChangeCharacter + invalid + range + space + e + lineChangeCharacter);
			// Reporting
			reporting(invalid + range + space + e + lineChangeCharacter);
			System.out.print(enter + range + example);
			// Reporting
			reporting(enter + range + example);
			readDataFromYAML(positiveScenario, startingRange, 0);
		}
		return rangeValue;
	}
}
