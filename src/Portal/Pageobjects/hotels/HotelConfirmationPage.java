package Portal.Pageobjects.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import satguru.generic.ElementCheck;


public class HotelConfirmationPage {
	@FindBy(xpath="//a[contains(text(),'View Voucher')]")
	private WebElement ViewVoucher;
	@FindBy(xpath="//div[@class='travel-itinerary']//li[@class='text-right ng-scope']/span")
	private WebElement BookingRefnum;
	
	
	public HotelConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void confirmBooking(WebDriver driver) {
		boolean a = ElementCheck.textPresence("View Voucher", driver);
		if (a) {
			System.out.println("Hotel booking cinfirmed with referance number "+BookingRefnum.getText());
			
		} else {
			System.out.println("Hotel booking failed with referance number "+BookingRefnum.getText());

		}
	}

}
