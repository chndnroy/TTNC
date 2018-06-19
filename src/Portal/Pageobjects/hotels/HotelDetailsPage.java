package Portal.Pageobjects.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailsPage {
	@FindBy(xpath="//input[@name='termsConditionChk']")
	private WebElement TermNConditionChk;
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement ContinueBtn;
	
	public HotelDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContinue() {
		if (ContinueBtn.isEnabled()) {
			TermNConditionChk.click();
			ContinueBtn.click();
			
		}
		
	}
	
	

}
