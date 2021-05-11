package stepsDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import others.BaseClass;
import pages.InsuranceProjectPage;
import utilities.Constants;

public class InsuranceProjectSteps extends InsuranceProjectPage implements Constants {
	BaseClass baseClass = new BaseClass();
	WebDriver webDriver = BaseClass.webDriver;
	String email = "test.user@gmail.com";
	String password = "test";
	
	@Given("^User is at Insurance Project page$")
	public void nagivateToInsurancePage() {
		webDriver.findElement(getInsuranceProjectLink()).click();
		Assert.assertEquals("Insurance Broker System - Login", webDriver.getTitle());
		
	}

	@When("^User clicks on Register button$")
	public void clickOnRegistrationBtn() {
		webDriver.findElement(registerBtn()).click();
		Assert.assertEquals("Insurance Broker System - Register", webDriver.getTitle());
	}

	@When("^User fill ups the registration form$")
	public void fillUserForm() {
		fillForm();
	}

	@When("^User clicks on Create button$")
	public void clickOnCreateBtn() {
		webDriver.findElement(getCreateBtn()).click();
	}

	@When("^User enters email$")
	public void eneterEmailID() {
		webDriver.findElement(getLoginEmailID()).sendKeys(email);
	}

	@When("^User enters password$")
	public void enetrPassword() {
		webDriver.findElement(getLoginPassword()).sendKeys(password);
	}

	@When("^User clicks on Login button$")
	public void clickOnLoginBtn() {
		webDriver.findElement(getLoginBtn()).click();
	}

	@Then("^User navigates to login page for Insurance Project automatically$")
	public void navigateToInsuranceLoginPage() {
		Assert.assertEquals(true, webDriver.findElement(getLoginBtn()).isDisplayed());
	}

	@Then("^User page is displayed$")
	public void verifyUserEmailID() {
		Assert.assertEquals(email, webDriver.findElement(getUserEmailId()).getText());
	}

	public void fillForm() {
		Select title = new Select(webDriver.findElement(titleDropDown()));
		title.selectByValue("Mr");
		webDriver.findElement(getFirstName()).sendKeys("Test");
		webDriver.findElement(getSurname()).sendKeys("User");
		webDriver.findElement(getPhone()).sendKeys("1234567890");

		Select birthYear = new Select(webDriver.findElement(getYear()));
		birthYear.selectByValue("1993");
		Select birthMonth = new Select(webDriver.findElement(getMonth()));
		birthMonth.selectByVisibleText("July");
		Select birthDay = new Select(webDriver.findElement(getDay()));
		birthDay.selectByValue("15");

		webDriver.findElement(getEmailID()).sendKeys(email);
		webDriver.findElement(getPassword()).sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(getConfirmPassword()).clear();
		webDriver.findElement(getConfirmPassword()).sendKeys(password);
	}
	
}
