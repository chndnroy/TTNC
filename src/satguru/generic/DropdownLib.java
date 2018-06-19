package satguru.generic;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownLib {
	public  static void ChoosebyIndex(WebDriver driver,WebElement element, int number) {
		Select se=new Select(element);
		se.selectByIndex(number);
				}
	public  static void Choosebytext(WebDriver driver,WebElement element, String text) {
		Select se=new Select(element);
		se.selectByVisibleText(text);
				}
	public  static void Choosebyvalue(WebDriver driver,WebElement element, String value) {
		Select se=new Select(element);
		se.selectByValue(value);;
				}
	public static void SelectByTextFromDropdown(WebDriver driver,WebElement element,int number) {
		
	Select s=new Select(element);
	List<WebElement> a = s.getOptions();
	System.out.println("Option choosen from Dropdown is "+a.get(number).getText());
	DropdownLib.Choosebytext(driver, element, a.get(1).getText());
	}

}


