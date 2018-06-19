package Portal.Pageobjects.Insurance;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceSearchPage {
	@FindBy(id="origin")
	private WebElement OriginField;
	@FindBy(id="destination")
	private WebElement DestinationField;
	@FindBy(id="travelDate")
	private WebElement StartDate;
	@FindBy(id="returnDate")
	private WebElement Returndate;
	@FindBy(id="ageAdult_1")
	private WebElement AdultAgeField;
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement NxtMnthBtn;
	@FindBy(xpath = "//a[text()=11]")
	private WebElement selectdate1;
	@FindBy(xpath="//input[@value='SEARCH']")
	private WebElement SearchButton;
	
	
	public InsuranceSearchPage(WebDriver driver) {
PageFactory.initElements(driver, this);	
}
	public void Insuranceinput(String origin,String destination,String age) throws InterruptedException {
		OriginField.sendKeys(origin);
		Thread.sleep(2000);
		OriginField.sendKeys(Keys.ENTER);
		DestinationField.sendKeys(destination);
		Thread.sleep(2000);
		DestinationField.sendKeys(Keys.ENTER);
		StartDate.click();
		NxtMnthBtn.click();
		selectdate1.click();
		AdultAgeField.sendKeys(age);
		SearchButton.click();
		
	}

}
