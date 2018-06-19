package satguru.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementPresance {
	public boolean isPresent(WebElement element, WebDriver driver)
	   {
		if (element.hashCode()>0) {
			return true;
			
		} else {
			return false;

		}

	}
}
