package satguru.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementCheck {
//	public static boolean isTextOnPagePresent(String text,WebDriver driver) {
//	    WebElement body = driver.findElement(By.tagName("body"));
//	    String bodyText = body.getText();
//	    return bodyText.contains(text);
//	}
	public static boolean textPresence(String text, WebDriver driver)
	{
	try{	if(driver.getPageSource().contains(text))
	{
			System.out.println("Text is present");
			return true;
			}
	else{
		return false;
	}
	}
	catch (Exception e) {
		e.getMessage();
			return false;
			}
	}
	
}
