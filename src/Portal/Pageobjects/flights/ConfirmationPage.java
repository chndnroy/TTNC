package Portal.Pageobjects.flights;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ConfirmationPage {
	@FindBy(xpath = "//p[contains(text(),'Airline PNR')]")
	private WebElement AirlinePNRMsg;
	@FindBy(xpath = "//tr/td[2]/strong")
	private WebElement AirlinePNRnumber;
	@FindBy(xpath = "//tr/td[1]/strong")
	private WebElement GDSPNRnum;
	@FindBy(xpath = "//a[contains(text(),'eTicket')]")
	private WebElement ViewEticket;
	@FindBy(xpath="//a[contains(text(),'Click here to continue')]/..")
	private WebElement ErrorMsg;
	@FindBy(xpath="//span[@data-ng-bind='flightInformation.bookingRefNo']")
	private WebElement ConfirmRefNumber;
	@FindBy(xpath="//td[contains(text(),'Order Details')]")
	private WebElement Order;
	
	WebDriver driver;


	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

public void ConfirmBooking() {
		
		
		Order.getText();

//	boolean a = ElementCheck.textPresence("eTicket", driver);
//		if(a)
//		{
//		System.out.println("Flight Booking is confirmed with Booking Reference :"+ConfirmRefNumber.getText());
//
//		}
//		else   {
//			WaitStatementLib.implicitWaitforSeconds(driver, 10);
//			ConfirmRefNumber.isDisplayed();
//			
//			System.out.println("Booking failed with Referance number "+ConfirmRefNumber.getText());
//		}
//			
		
		try{
			ViewEticket.isDisplayed();
			System.out.println("Flight Booking is confirmed with Booking Reference :"+ConfirmRefNumber.getText());
		}
		catch (Exception e) {
			e.getMessage();
			System.out.println("Booking failed with Referance number "+ConfirmRefNumber.getText());

		}
	}
}
