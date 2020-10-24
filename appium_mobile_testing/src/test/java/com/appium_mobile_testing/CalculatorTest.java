package com.appium_mobile_testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.http.HttpClient;

public class CalculatorTest {
	
	//WebDriver wDriver;
	static AppiumDriver<MobileElement> appiumD;
	//static AndroidDriver<MobileElement> aDriver;
	//IOSDriver<WebElement> iDriver;
	
	public static void main(String[] args) {
		openCalculator();
	}
	
	public static void openCalculator() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "OnePlus 7 Pro");
		cap.setCapability("udid", "b19c5982");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "com.oneplus.calculator");
		cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");
		
		URL url;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			appiumD = new AppiumDriver<MobileElement>(url, cap);
			//aDriver = new AndroidDriver<MobileElement>(url, cap);
			System.out.println("Starting......");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MobileElement btn_seven = appiumD.findElement(By.id("com.oneplus.calculator:id/digit_7"));
		MobileElement btn_three = appiumD.findElement(By.id("com.oneplus.calculator:id/digit_3"));
		MobileElement btn_plus = appiumD.findElement(By.id("com.oneplus.calculator:id/op_add"));
		MobileElement btn_equal = appiumD.findElement(By.id("com.oneplus.calculator:id/eq"));
		MobileElement result = appiumD.findElement(By.id("com.oneplus.calculator:id/result"));
		btn_seven.click();
		btn_plus.click();
		btn_three.click();
		btn_equal.click();
		String result_cal = result.getText();
		System.out.println("Result is: "+result_cal);
		System.out.println("Text: "+btn_seven.getText());
		System.out.println("Text: "+btn_three.getText());
	}
}
