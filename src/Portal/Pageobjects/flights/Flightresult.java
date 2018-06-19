package Portal.Pageobjects.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import satguru.generic.WaitStatementLib;

import java.awt.Robot;
import java.util.List;


public class Flightresult {
	public Flightresult(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-ng-disabled='searchflightName']")
	private WebElement airlinesearchBox;
	@FindBy(xpath = "(//a[contains(text(),'Book Now')])[1]")
	private WebElement Bookbtn;
	@FindBy(xpath = "//div[@data-name='OFFER']//img/../../..//a[contains(text(),'Book Now')]")
	private WebElement LccSpecialBookBtn;
	@FindBy(xpath = "//p[text()='Basic']/../..//a[contains(text(),'Book Now')]")
	private WebElement BasicBook;
	// @FindBy(xpath = "//div[@id='price-change']//div")
	// private WebElement FareChangePopup;
	@FindBy(xpath = "//a[@class='btn orange-btn'][contains(text(),'Continue')]")
	public static WebElement ContinueBtn;
	@FindBy(xpath = "//p[@class='new-price green']//strong")
	public static WebElement downfare;
	@FindBy(xpath = "//p[@strong='new-price red']//strong")
	public static WebElement upFare;
	@FindBy(xpath = "//p[contains(text(),'Change')]/../..//a[contains(text(),'Book Now')]")
	private WebElement BookFlyDubaiBtn;
	@FindBy(xpath = "//img[@data-ng-show='whiteMarkup']")
	private WebElement OntheFlyMarkupBtn;
	@FindBy(xpath = "//div[@id='up']//div[@class='modal-body")
	private static WebElement FareUp;
	@FindBy(xpath = "//div[@id='down']//div[@class='modal-body")
	private static WebElement Faredown;
	@FindBy(xpath = "//div[@class='flight-details']//input")
	private WebElement SelectFlight;
	@FindBy(id = "send-quote")
	private WebElement sendquote;
	@FindBy(xpath = "//input[@id='save-quote']")
	private WebElement savequote;
	@FindBy(xpath = "//h4[text()='SAVE QUOTE']")
	private WebElement SaveQuotePopup;
	@FindBy(xpath = "//h4[text()='SEND QUOTE']")
	private WebElement SendQuotePopup;
	@FindBy(id = "nameQuote1")
	private WebElement NameQuote;
	@FindBy(xpath = "//button[@data-ng-if='!isSendQuote']")
	private WebElement saveQuoteButton;
	@FindBy(id = "add-email")
	private WebElement AddemailButtonQuote;
	@FindBy(id = "emailQuote1")
	private WebElement email1;
	@FindBy(xpath = "//div[@data-ng-bind-html='resultMessageQuotation']//b")
	private WebElement QuotationNumber;
	@FindBy(xpath = "//button[contains(text(),'SEND QUOTATION')]")
	private WebElement SendQuotaionPopupBtn;
	@FindBy(xpath = "//a[text()='All Airlines']")
	private WebElement AllAirline;

	WebDriver driver;

	public void book(WebDriver driver) {
		WaitStatementLib.explicitWaitForClickable(driver, 2, Bookbtn);
		Bookbtn.click();

		System.out.println("Book Button clicked");

	}

	public void BasicBook(WebDriver driver) {
		WaitStatementLib.explicitWaitForClickable(driver, 2, BasicBook);
		BasicBook.click();

	}

	

	public void BookLCCSpecial(WebDriver driver) {
		LccSpecialBookBtn.click();

	}

	public static boolean farechange(WebDriver driver) {
		try {
			if (ContinueBtn.isDisplayed()) {
				System.out.println("fare has been changed");
				System.out.println("continue button clicked");
				ContinueBtn.click();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.getMessage();
			return false;
		}

	}

	public void BookFlydubaiBtn(WebDriver driver) {
		OntheFlyMarkupBtn.click();
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		BookFlyDubaiBtn.click();

	}

	public String resultsPagesSavequote(String passenger) throws InterruptedException {
		if (AllAirline.hashCode() != 0)

			// WaitStatementLib.implicitWaitforSeconds(driver, 60);
			System.out.println(AllAirline.getText());
		SelectFlight.click();
		savequote.click();
		Thread.sleep(5000);
		if (SaveQuotePopup.hashCode() != 0)
			System.out.println("Save Quote Popup is displaying");
		NameQuote.click();

		NameQuote.sendKeys(passenger);
		Thread.sleep(2000);
		NameQuote.sendKeys(Keys.ENTER);
		// AddemailButtonQuote.click();
		// email1.sendKeys("mukta.g@techtreeit.com");
		// System.out.println("Extra email id added");
		saveQuoteButton.click();
		Thread.sleep(5000);

		System.out.println("Quotation number appearing");

		String a = QuotationNumber.getText();
		return a;
	}

	public void resultsPagesSendquote(String passenger) {
		if (savequote.hashCode() != 0)
			SelectFlight.click();
		sendquote.click();
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		if (SendQuotePopup.isDisplayed()) {
			NameQuote.sendKeys(passenger);
			NameQuote.sendKeys(Keys.ENTER);
			AddemailButtonQuote.click();
			email1.sendKeys("mukta.g@techtreeit.com");
			saveQuoteButton.click();
			WaitStatementLib.implicitWaitforSeconds(driver, 10);
			SendQuotaionPopupBtn.click();

		}
	}

	public String multicityQuote(String passenger) throws InterruptedException {
		if (Bookbtn.hashCode() != 0)
			SelectFlight.click();
		savequote.click();
		Thread.sleep(5000);
		if (SaveQuotePopup.hashCode() != 0)
			System.out.println("Save Quote Popup is displaying");
		NameQuote.click();

		NameQuote.sendKeys(passenger);
		Thread.sleep(2000);
		NameQuote.sendKeys(Keys.ENTER);
		// AddemailButtonQuote.click();
		// email1.sendKeys("mukta.g@techtreeit.com");
		// System.out.println("Extra email id added");
		saveQuoteButton.click();
		Thread.sleep(5000);

		System.out.println("Quotation number appearing");

		String a = QuotationNumber.getText();
		return a;
	}
}
