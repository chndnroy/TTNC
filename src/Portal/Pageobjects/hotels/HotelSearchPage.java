package Portal.Pageobjects.hotels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import satguru.generic.DropdownLib;


public class HotelSearchPage {
	@FindBy(id="search")
	private WebElement SearchField;
	@FindBy(id="checkIn")
	private WebElement ChkInDateCal;
	@FindBy(xpath="//span[text()='Next']")
	private WebElement NxtMnthBtn;
    @FindBy(xpath="//a[text()=15]")
    private WebElement SelectDate1;
	@FindBy(id="checkOut")
	private WebElement checkOutCal;
	@FindBy(xpath="//p[@class='add-e add-rooms']")
	private WebElement AddRumBtn;
	@FindBy(id="nationality")
	private WebElement NationalityField;
	@FindBy(id="residence")
	private WebElement Countryofresidance;
	@FindBy(xpath="//input[@value='SEARCH']")
	private WebElement SearchBtn;
	@FindBy(id="child-1")
	private WebElement childdrpDwnroom1;
	@FindBy(id="childAge-0")
	private WebElement childAgeDrpDwn1;
	
	public HotelSearchPage(WebDriver driver)
	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	WebDriver driver;
	
	public void Hotelsearch(String City,String Country) throws InterruptedException {
		SearchField.sendKeys(City);
		Thread.sleep(5000);
		SearchField.sendKeys(Keys.ENTER);
		ChkInDateCal.click();
		DropdownLib.Choosebyvalue(driver, childdrpDwnroom1, "1");
		NxtMnthBtn.click();
		SelectDate1.click();
		NationalityField.sendKeys(Country);
		Thread.sleep(2000);
		NationalityField.sendKeys(Keys.ENTER);
		Countryofresidance.sendKeys(Country);
		Thread.sleep(2000);
		Countryofresidance.sendKeys(Keys.ENTER);
		SearchBtn.click();
		
	}
}
