package Portal.Pageobjects.hotels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HotelInfoPage {
	@FindBy(xpath = "//div[@class='book-now']//a[contains(text(),'Book')]")
	private WebElement DetailBookbtn;
	@FindBy(xpath = "//input[@id='save_quote']")
	private WebElement saveQuote;
	@FindBy(xpath = "//h4[text()='SAVE QUOTE']")
	private WebElement SaveQuotePopup;
	@FindBy(xpath = "//h4[text()='SEND QUOTE']")
	private WebElement SendQuotePopup;
	@FindBy(id = "nameQuote_wrap1")
	private WebElement NameQuote;
	@FindBy(xpath = "//button[@type='button']")
	private WebElement saveQuoteButton;
	@FindBy(id = "add-email")
	private WebElement AddemailButtonQuote;
	@FindBy(id = "emailQuote1")
	private WebElement email1;
	@FindBy(xpath = "//div[@ng-bind-html='resultMessageQuotation']//b")
	private WebElement QuotationNumber;

	public HotelInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ClikOnBukBtn(WebDriver driver) throws InterruptedException {
		Thread.sleep(10000);
		DetailBookbtn.click();
	}

	public String SaveQuote(String passenger) {

		if (saveQuote.isEnabled())

			saveQuote.click();
		System.out.println("Save Quote Popup is displaying");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		NameQuote.click();

		NameQuote.sendKeys(passenger);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NameQuote.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		saveQuoteButton.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (QuotationNumber.isDisplayed() == true)
			System.out.println("Quotation number is displaying.");

		String a = QuotationNumber.getText();
		return a;

	}
}
