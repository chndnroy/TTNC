package Portal.Pageobjects.flights;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrossSellingPage {
	@FindBy(xpath="//a[@data-ng-click='passengerDetail();']")
	private WebElement NoThanksBtn;
	
	public CrossSellingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void noThanks() {
		if (NoThanksBtn.isEnabled()) {
		NoThanksBtn.click();
		System.out.println("Cross selling page is open");
	}

}
}
