package Portal.Pageobjects.Insurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceConfirmationPage {
	@FindBy(xpath="//span//span")
	private WebElement Tripid;
	
	
	public InsuranceConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ConfirmBooking() {
		try {Tripid.isDisplayed();
		System.out.println("Insurance Booking confirmed with Trip Id "+Tripid.getText());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
