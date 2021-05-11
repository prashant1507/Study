package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", //the path of the feature files
		glue={"stepsDefination","others"}, //the path of the step definition, BaseClass  packages
		monochrome = true, //display the console output in a proper readable format)
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper between feature file and step def file
		// format = {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"} //to generate different types of reporting
		//tags = {"@Smoke , @Regression"} // To run test case with tags
		)
public class TestRunner {
}


// tags = {"@Smoke , @Regression"} ->> Smoke OR Regression
// tags = {"@Smoke" , "@Regression"} ->> Smoke AND Regression
// tags = {"~@Smoke" , "~@Regression"}  ->> Do not run tags with Smoke AND Regression