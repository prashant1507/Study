package stepsDefination;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import others.BaseClass;
import pages.HomePage;
import utilities.Constants;

public class HomePageSteps extends HomePage implements Constants {

	BaseClass baseClass = new BaseClass();
	WebDriver webDriver = BaseClass.webDriver;

	@Given("^User navigates to the URL$")
	public void navigateToURL() {
		webDriver.get(Constants.url);
		Assert.assertEquals("Guru99 Bank Home Page", webDriver.getTitle());
	}

	@When("^User enters (blank|invalid|valid) email id$")
	public void enterEmailID(String emailType) {
		switch (emailType) {
		case "invalid":
			webDriver.findElement(getEmailID()).sendKeys("invalidEmailID.com");
			break;
		case "blank":
			webDriver.findElement(getEmailID()).sendKeys("");
			break;
		case "valid":
			webDriver.findElement(getEmailID()).sendKeys(baseClass.getProperty(emailID));
			break;
		}
	}

	@When("^User clicks on submit button$")
	public void clickOnSubmitBtn() {
		webDriver.findElement(getSubmitBtn()).click();
	}
	
	@When("^User enters invalid email address$")
	public void invalidEmailAddress(DataTable dt) {
		List<List<String>> data = dt.raw();
		String invalid = data.get(0).get(0); // from 0th column get 0th row
		if (invalid.equals("invalid"))
			webDriver.findElement(getEmailID()).sendKeys("invalidEmailID.com");
	}
	
	@Then("^Error message for invalid email is displayed$")
	public void invalidEmailErroMsg(DataTable dt) {
		List<List<String>> data = dt.raw();
		String expected = data.get(0).get(0); // from 0th column get 0th row
		String actual = webDriver.findElement(getErrorMsg()).getText();
		Assert.assertEquals(expected, actual);
	}

	@Then("^Username is displayed$")
	public void usernameIsDisplayed() {
		boolean isDisplayed = webDriver.findElement(getUserID()).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@Then("^Password is displayed$")
	public void passwordIsDisplayed() {
		boolean isDisplayed = webDriver.findElement(getPassword()).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@Then("^Error message '(.*)' is displayed$")
	public void errorMsgIsDisplayed(String errorMsg) {
		switch (errorMsg) {
		case "Email ID must not be blank":
			String forBlankErrorMsg = webDriver.findElement(getErrorMsg()).getText();
			Assert.assertEquals(errorMsg, forBlankErrorMsg);
			break;
		case "Email ID is not valid":
			String forInvalidErrorMsg = webDriver.findElement(getErrorMsg()).getText();
			Assert.assertEquals(errorMsg, forInvalidErrorMsg);
			break;
		}
	}
}
