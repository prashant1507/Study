package com.resassured.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class SampleTest {
    @Test(priority = 1, description = "Sample Test Case Selenium")
    @Description("Selenium Test Case")
    @Epic("Epic")
    @Feature("Feature")
    @Story("Story")
    @Step("Step")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("Allure ID")
    public void sampleMethod() {
        System.out.println("sample method");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        cap.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/");
        driver.findElement(By.id("email")).sendKeys("ss@ss.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
