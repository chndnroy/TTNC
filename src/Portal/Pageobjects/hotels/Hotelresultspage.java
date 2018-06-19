package Portal.Pageobjects.hotels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import satguru.generic.DropdownLib;



public class Hotelresultspage {
	@FindBy(xpath="//a[@class='btn orange-btn']")
	private WebElement Bookbtn;
	@FindBy(xpath="//span[@class='modify-search-btn btn orange-trans fa-css']")
	private WebElement ModifyButton;
	@FindBy(id="search")
	private WebElement SearchField;
	@FindBy(id="checkIn")
	private WebElement ChkInDateCal;
	@FindBy(xpath="//span[text()='Next']")
	private WebElement NxtMnthBtn;
    @FindBy(xpath="//a[text()=15]")
    private WebElement SelectDate1;
    @FindBy(xpath="//a[text()=20]")
    private WebElement SelectDate2;
    @FindBy(xpath="//a[text()=25]")
    private WebElement SelectDate3;
	@FindBy(id="checkOut")
	private WebElement checkOutCal;
	@FindBy(xpath="//p[@class='add-e add-rooms']")
	private WebElement AddRumBtn;
	@FindBy(id="nationality")
	private WebElement NationalityField;
	@FindBy(xpath="//input[@value='SEARCH']")
	private WebElement SearchBtn;
	@FindBy(id="child-0")
	private WebElement childdrpDwnModifyroom1;
	@FindBy(id="child-1")
	private WebElement childdrpDwnModifyroom2;
	@FindBy(xpath="//select[@id='hotelWidgetElement0.childAges0.age']")
	private WebElement childAgeDrpDwnmodifyroom1;
	@FindBy(xpath="//p[@class='add-e add-rooms']")
	private WebElement AddRoomModifybutton;
	@FindBy(xpath="//div[@id='room-2']//select[@class='adult']")
	private WebElement AdultDrpdwnModifyRoom2;
	@FindBy(xpath="//input[@id='modify-search']")
	private WebElement searchButtonModify;
	@FindBy(xpath="(//input[@name='hotel1'])[1]")
	private WebElement SelectHotel1;
	@FindBy(xpath="//input[@id='save-quote']")
	private WebElement saveQuote;
	@FindBy(xpath = "//h4[text()='SAVE QUOTE']")
	private WebElement SaveQuotePopup;
	@FindBy(xpath = "//h4[text()='SEND QUOTE']")
	private WebElement SendQuotePopup;
	@FindBy(id = "nameQuote_wrap1")
	private WebElement NameQuote;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveQuoteButton;
	@FindBy(id = "add-email")
	private WebElement AddemailButtonQuote;
	@FindBy(id = "emailQuote1")
	private WebElement email1;
	@FindBy(xpath = "//div[@ng-bind-html='resultMessageQuotation']//b")
	private WebElement QuotationNumber;
	
	WebDriver driver;
	public Hotelresultspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickOnBukBtn() {
		Bookbtn.click();
	}

	public void Modifychangedate() {
			
		Bookbtn.click();		
		ModifyButton.click();
		ChkInDateCal.click();
		SelectDate2.click();
		searchButtonModify.click();
		
	}
	public void  ModifyChangeRoom() {
		Bookbtn.click();		
		ModifyButton.click();
		AddRoomModifybutton.click();
		//DropdownLib.Choosebyvalue(driver, AdultDrpdwnModifyRoom2, "1");
		DropdownLib.Choosebyvalue(driver, childdrpDwnModifyroom2, "1");
		searchButtonModify.click();
		
	}
	public String SaveQuote(String passenger) {
		if (Bookbtn.hashCode()!=0)
			SelectHotel1.click();
			saveQuote.click();
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if (SaveQuotePopup.hashCode() != 0)
				System.out.println("Save Quote Popup is displaying");
			NameQuote.click();

			NameQuote.sendKeys(passenger);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			NameQuote.sendKeys(Keys.ENTER);
			saveQuoteButton.click();
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		if(QuotationNumber.isDisplayed()==true)
			System.out.println("Quotation number is displaying.");
		
	String a=QuotationNumber.getText();
	return a;
		
	}
}
