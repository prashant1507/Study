package pages;

import org.openqa.selenium.By;

public class HomePage {

	String emailIDTextbox = "emailid";
	String submitBtn = "btnLogin";
	String userId = "//td[text()='User ID :']/following-sibling::td";
	String password = "//td[text()='Password :']/following-sibling::td";
	String errorMsgText = "message9";
	
	public By getEmailID() {
		return By.name(emailIDTextbox);
	}
	
	public By getSubmitBtn() {
		return By.name(submitBtn);
	}
	
	public By getUserID() {
		return By.xpath(userId);
	}
	
	public By getPassword() {
		return By.xpath(password);
	}
	
	public By getErrorMsg() {
		return By.id(errorMsgText);
	}
}
