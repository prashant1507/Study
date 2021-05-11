package pages;

import org.openqa.selenium.By;

public class InsuranceProjectPage {

	String insuranceProjectLink = "Insurance Project";
	String registerBtn = "//a[text()='Register']";
	String title = "user_title";
	String firstNameTextBox = "user_firstname";
	String surnameTextBox = "user_surname";
	String phoneTextBox = "user_phone";
	String birthYear = "user_dateofbirth_1i";
	String birthMonth = "user_dateofbirth_2i";
	String birthDay = "user_dateofbirth_3i";
	String emailIDTextBox = "user_user_detail_attributes_email";
	String passwordTextBox = "user_user_detail_attributes_password";
	String confirmPasswordTextBox = "user_user_detail_attributes_password_confirmation";
	String createBtn = "submit";
	String resetBtn = "resetform";
	String loginEmailId = "email";
	String loginPassword = "password";
	String loginBtn = "submit";
	String userEmailIdText = "//div[@class='content']/h4";

	public By getInsuranceProjectLink() {
		return By.linkText(insuranceProjectLink);
	}

	public By registerBtn() {
		return By.xpath(registerBtn);
	}

	public By titleDropDown() {
		return By.id(title);
	}

	public By getFirstName() {
		return By.id(firstNameTextBox);
	}

	public By getPhone() {
		return By.id(phoneTextBox);
	}

	public By getYear() {
		return By.id(birthYear);
	}

	public By getMonth() {
		return By.id(birthMonth);
	}

	public By getDay() {
		return By.id(birthDay);
	}

	public By getEmailID() {
		return By.id(emailIDTextBox);
	}

	public By getPassword() {
		return By.id(passwordTextBox);
	}

	public By getConfirmPassword() {
		return By.id(confirmPasswordTextBox);
	}

	public By getSurname() {
		return By.id(confirmPasswordTextBox);
	}

	public By getCreateBtn() {
		return By.name(createBtn);
	}

	public By getResetBtn() {
		return By.id(resetBtn);
	}

	public By getLoginEmailID() {
		return By.id(loginEmailId);
	}

	public By getLoginPassword() {
		return By.id(loginPassword);
	}

	public By getLoginBtn() {
		return By.name(loginBtn);
	}

	public By getUserEmailId() {
		return By.xpath(userEmailIdText);
	}
}
