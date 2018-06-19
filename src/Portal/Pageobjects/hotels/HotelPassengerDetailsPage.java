package Portal.Pageobjects.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HotelPassengerDetailsPage {
	@FindBy(id = "adultPax")
	private WebElement SelectAdultPassenger1Btn;
	@FindBy(id = "inputName")
	private WebElement SearchBox;
	@FindBy(id = "searchPaxBtn")
	private WebElement SearchBtn;
	@FindBy(xpath = "(//table//input)[1]")
	private WebElement FirstResult;
	@FindBy(xpath = "//input[@value='SELECT']")
	private WebElement SelectFirstResult;
	@FindBy(xpath = "//input[@value='Book']")
	private WebElement BookButn;
	@FindBy(id="childPax")
	private WebElement SelectChild1Passenger;

	
	public HotelPassengerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	public void searchAdultPass(String passengerName, WebDriver driver) {
		SelectAdultPassenger1Btn.click();

		SearchBox.sendKeys(passengerName);
		SearchBtn.click();
		FirstResult.click();
		SelectFirstResult.click();
		System.out.println("Adult selected from Select Passenger");
		
			}
	public void searchChild1Passenger(String childName) throws InterruptedException {

		SelectChild1Passenger.click();
		Thread.sleep(5000);
		SearchBox.sendKeys("child");
		Thread.sleep(3000);
		SearchBtn.click();

		FirstResult.click();
		SelectFirstResult.click();
		System.out.println(" first child selected from Select Passenger");
		
	}
	public void clickBookBtn() {
		
		BookButn.click();
		System.out.println("Book button clicked on Passenger details page");
	}
}