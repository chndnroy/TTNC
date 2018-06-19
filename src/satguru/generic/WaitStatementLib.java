package satguru.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {

	public static void implicitWaitforSeconds(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	public static void implicitWaitforMinutes(WebDriver driver,int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
		
	}
public static void explicitWaitForClickable(WebDriver driver,int time,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
public static void explicitWaitForVisibility(WebDriver driver,int time,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}

	
}


