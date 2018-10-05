package satguru.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	//final driver
	public WebDriver driver;

	@BeforeMethod
	@Parameters(value = "browser")
	public void preCondition(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","/home/ttuser10/Downloads/geckodriver");
			driver = new FirefoxDriver();
			Reporter.log("Firefox launched", true);
		} else if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/home/ttuser10/Desktop/chromedriver");
			driver = new ChromeDriver();
			Reporter.log("Chrome launched", true);

		

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(GetPropertyValue.getPropertyValue("UAT"));
		Reporter.log("Navigating to the test URL");

	}

	@AfterMethod
	public void postCondition(ITestResult result) {
		if(result.isSuccess())
		{
			Reporter.log("script passed",true);
		}
		
		else {
			Reporter.log("Script failed",true);
			String fileName = result.getMethod().getMethodName();
			ScreenshotLib slib=new ScreenshotLib();
			slib.getScreenshot(driver, fileName);
			Reporter.log("screenshot has been taken",true);
		}
		//driver.close();
		Reporter.log("Browser closed",true);
		
		

	
		
		Sendattachmentmail sam=new Sendattachmentmail();
	//sam.sendmail();
	}
}


