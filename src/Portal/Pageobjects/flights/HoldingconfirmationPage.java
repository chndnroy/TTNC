package Portal.Pageobjects.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HoldingconfirmationPage {
	@FindBy(xpath="//td[contains(text(),'Order Details')]/../..//span[@data-ng-bind='flightInformation.bookingRefNo']")
	private WebElement ErrorMsg;
	@FindBy(xpath="//span[@data-ng-bind='flightInformation.bookingRefNo']")
	private WebElement ConfirmRefNumber;
	@FindBy(xpath="//td[contains(text(),'Order Details')]")
	private WebElement Order;
	@FindBy(xpath="//div[@class='container']//tr[@class='ng-scope']//p")
	private WebElement Holdconfirm;
	WebDriver driver;
	
	public HoldingconfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

public void confirmHolding() {
	try {Holdconfirm.isDisplayed();
	System.out.println(Holdconfirm.getText());
	System.out.println("Refrerance number "+ConfirmRefNumber.getTagName());
		
	} catch (Exception e) {
		System.out.println("Booking failed with Referance number "+ErrorMsg.getText());
	}
//	if(ElementCheck.isTextOnPagePresent("Departures", driver))
//	{
//		System.out.println("Flight booking holded  with Booking Reference :"+ConfirmRefNumber.getText());
//	}
//	else {
//		System.out.println("Booking failed with Referance number "+ErrorMsg.getText());
//	}
//		
		
		
}
}
