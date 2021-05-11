package others;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseClass {

	public static WebDriver webDriver;

	@SuppressWarnings("deprecation")
	@Before
	public void setDriver() {
		WebDriver webDriver;
		if (getProperty("browser").equals("chrome")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			System.setProperty("webdriver.chrome.driver", "Resources/Drivers/chromedriver.exe");
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			cap.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			webDriver = new ChromeDriver(cap);
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			// webDriver.manage().window().maximize();
			BaseClass.webDriver = webDriver;
			System.out.println(Thread.currentThread());
		}
		
	}

	@After
	public void tearDown() {
		webDriver.close();
		webDriver.quit();
	}
	
	@Before("@First")
	public void specialHookBefore() {
		// this will run only for @First tag test case in feature file - before @Before
		// Its like before method in testng
		System.out.println("hello special hook");
	}
	
	@After("@First")
	public void specialHookAfter() {
		// this will run only for @First tag test case in feature file - after @First
		System.out.println("hello special hook After");
	}

	public String getProperty(String propertyname) {
		FileReader fr;
		Properties p = new Properties();
		try {
			fr = new FileReader("Resources/details.properties");
			p.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyname);
	}
}
