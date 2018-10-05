package satguru.pageobjects;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import satguru.generic.DropdownLib;
import satguru.generic.MouseOperations;
import satguru.generic.WaitStatementLib;

public class BasePage {
	@FindBy(xpath = "//title")
	private WebElement Title;
	@FindBy(id = "MidOfficeBooking")
	private WebElement MidOfficeBookingBtn;
	@FindBy(xpath = "//li[@id='Booking']/a")
	private WebElement BookingBtn;
	@FindBy(id = "branchListId")
	private WebElement BranchDrpDwn;
	@FindBy(xpath = "//img[@alt='home-icon']")
	private WebElement Homepage_Button;

	@FindBy(xpath = "//img[@alt='flight-icon']")
	private WebElement Flight_Page;

	@FindBy(xpath = "//img[@title='Hotel']")
	private WebElement Hotel_Page;

	@FindBy(xpath = "//img[@title='Insurance']")
	private WebElement Insurance_Page;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void booking(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(MidOfficeBookingBtn).perform();
		// WaitStatementLib.implicitWaitforMinutes(driver, 1);
		// assertEquals(BranchDrpDwn.isEnabled(), true,"Bookings page opening
		// failed");
		// MidOfficeBookingBtn.click();
		a.moveToElement(BookingBtn).click().perform();

		System.out.println("Booking module for Midoffice successfully opened");

	}

	public void BranchBooking(WebDriver driver) {
		DropdownLib.SelectByTextFromDropdown(driver, BranchDrpDwn, 1);

	}

	public void Homepage() {
		Homepage_Button.click();

	}

	public void Flight() {
		Flight_Page.click();

	}

	public void Hotel() {
		Hotel_Page.click();

	}

	public void Insurance() {
		Insurance_Page.click();

	}
}
