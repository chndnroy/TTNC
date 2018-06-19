package satguru.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseOperations {
	public static void hovering(WebDriver driver, WebElement element) {
		Actions a =new Actions(driver);
		a.moveToElement(element).perform();
		
		
	}

}
