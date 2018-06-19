package Portal.Pageobjects.Insurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceDetailsPage{
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement ContinueBtn;
	
	
	public InsuranceDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickContinue() {
		ContinueBtn.click();
		System.out.println("Insurance details page is open");
		
	}
	
}
