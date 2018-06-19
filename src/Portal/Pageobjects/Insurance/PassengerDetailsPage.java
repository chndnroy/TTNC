package Portal.Pageobjects.Insurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassengerDetailsPage {
	@FindBy(id="adultPax")
	private WebElement SelectAdultPassengerBtn;
	@FindBy(xpath = "//div[@class='modal-content']//input[@id='inputName']")
	private WebElement SearchBox;
	@FindBy(xpath = "//input[@id='searchPaxBtn']")
	private WebElement SearchBtn;
	@FindBy(xpath = "(//input[@name='paxRadio'])[1]")
	private WebElement FirstResult;
	@FindBy(xpath = "//input[@value='SELECT']")
	private WebElement SelectFirstResult;
	@FindBy(id="passengerAddress_0")
	private WebElement Addressfield;
	@FindBy(xpath="//input[@placeholder='City']")
	private WebElement Cityfield;
	@FindBy(xpath="//input[@placeholder='Province']")
	private WebElement ProvinceField;
	@FindBy(xpath = "//input[@value='Book']")
	private WebElement BookButn;
	
	public PassengerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectPassenger(String Adult1) {
		if (SelectAdultPassengerBtn.isEnabled()) {

			SelectAdultPassengerBtn.click();
			SearchBox.sendKeys(Adult1);
			SearchBtn.click();

			FirstResult.click();
			SelectFirstResult.click();
			System.out.println(" first Adult selected from Select Passenger");
			Addressfield.sendKeys("jhgjjhgjgjh");
			Cityfield.sendKeys("yguyjgyufguyfg");
			ProvinceField.sendKeys("tdyfgguihioojl");
			
		}
		
		}
	public void ProceedFrBuk() {
		BookButn.click();
	
	}
}
