package Portal.Pageobjects.flights;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import satguru.generic.ElementCheck;
import satguru.generic.WaitStatementLib;



public class FlightDetailsPage {
	@FindBy(xpath = "//a[@data-ng-click='flightReviewClick();']")
	private WebElement ContinueBtn;
	@FindBy(xpath = "//strong[contains(text(),'Secure your trip')]")
	private WebElement InsureChk;
	@FindBy(xpath = "//li[@class='ul-li-ol-style ng-scope']//input[@name='insuranceRadio']")
	private WebElement selectInsurance;
	@FindBy(xpath = "//li[@class='ul-li-ol-style ng-scope']//strong")
	private WebElement InsuranceOption;
	@FindBy(id = "iAccept")
	private WebElement acceptTerms;
	@FindBy(xpath = "//span[contains(text(),'There is no Insurance')]")
	private WebElement NoInsuranceMsg;
	@FindBy(xpath = "//input[@value='notRequired']")
	private WebElement SelectNoInsuranceOption;
	@FindBy(xpath = "//input[@value='Save Quote']")
	private WebElement SaveQuote;
	@FindBy(xpath = "//h4[text()='SAVE QUOTE']")
	private WebElement SaveQuotePopup;
	@FindBy(xpath = "//h4[text()='SEND QUOTE']")
	private WebElement SendQuotePopup;
	@FindBy(id = "nameQuote1")
	private WebElement NameQuote;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveQuoteButton;
	@FindBy(id = "add-email")
	private WebElement AddemailButtonQuote;
	@FindBy(id = "emailQuote1")
	private WebElement email1;
	@FindBy(xpath = "//div[@data-ng-bind-html='resultMessageQuotation']//b")
	private WebElement QuotationNumber;

	public FlightDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	public void clickContinue(WebDriver driver) {
		// WaitStatementLib.explicitWaitForVisibility(driver, 2,
		// NoInsuranceMsg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ContinueBtn.isEnabled())
			System.out.println("Flight details page is open");
		if (ElementCheck.textPresence("AL SAGR", driver) == true) {
			SelectNoInsuranceOption.click();
			System.out.println("Insurance bypassed");
			ContinueBtn.click();
		} else {
			System.out.println("No insurance option available");
			ContinueBtn.click();
		}

		// if (InsureChk.isDisplayed()) {
		// WaitStatementLib.implicitWaitforMinutes(driver, 1);
		// SelectNoInsuranceOption.click();
		// ContinueBtn.click();
		//
		// } else {
		// ContinueBtn.click();
		// }
		// if(!ElementCheck.isTextOnPagePresent("Age", driver))
		// {
		// SelectNoInsuranceOption.click();
		// ContinueBtn.click();
		// }
		//
	}

	public void OnewaydetailPage() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ContinueBtn.isEnabled())
			System.out.println("FLight details page is open");
		ContinueBtn.click();

	}

	public void FLightNInsurance(WebDriver driver) {
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ContinueBtn.isEnabled()) {
			System.out.println("Flight details page is open");
			WaitStatementLib.implicitWaitforSeconds(driver, 5);
			if (ElementCheck.textPresence("AL SAGR", driver) == true) {

				// if (InsureChk.isDisplayed())
				selectInsurance.click();
				WaitStatementLib.implicitWaitforSeconds(driver, 5);
				acceptTerms.click();
				System.out.println("Insurance has been selected of price " + InsuranceOption.getText());
				ContinueBtn.click();
			} else if (ElementCheck.textPresence("AL SAGR", driver) == false)

				// ContinueBtn.click();
				System.out.println("Insurance option not available");

		}
	}

	public String DetailPageSaveQuote(String passenger) {
		SaveQuote.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

		if (SaveQuotePopup.hashCode() != 0) {
			System.out.println("Save Quote Popup is displaying");
			NameQuote.click();
			NameQuote.sendKeys(passenger);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NameQuote.click();
			NameQuote.sendKeys(Keys.BACK_SPACE);
			NameQuote.sendKeys(Keys.ENTER);
			AddemailButtonQuote.click();
			email1.sendKeys("mukta.g@techtreeit.com");
			System.out.println("Extra email id added");
			saveQuoteButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
				System.out.println("Quotation saved with number " + QuotationNumber.getText());
			
		}
		String a = QuotationNumber.getText();
		return a;

	}

}
