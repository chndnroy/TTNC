package Portal.Pageobjects.flights;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import satguru.generic.DropdownLib;
import satguru.generic.WaitStatementLib;



public class PassenegerDetailsPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@id='errPassenger_0']/..//p")
	private WebElement SelectAdultPassengerBtn;
	@FindBy(xpath = "//div[@id='errPassenger_1']/..//p")
	private WebElement SelectAdultPassenger2Btn;
	@FindBy(xpath = "(//p[@id='adultPax'])[3]")
	private WebElement SelectAdultPassenger3Btn;
	@FindBy(xpath = "(//p[@id='adultPax'])[4]")
	private WebElement SelectAdultPassenger4Btn;
	@FindBy(xpath = "//p[@id='childPax']/..//p[contains(text(),'SELECT PASSENGER')]")
	private WebElement SelectChild1PassengerBtn;
	@FindBy(xpath = "//p[@id='infantPax']/..//p[contains(text(),'SELECT PASSENGER')]")
	private WebElement SelectInfant1PassengerBtn;
	@FindBy(xpath = "//select//option[contains(text(),'Select Assign To')]/..")
	private WebElement InfantAssignTo;
	@FindBy(xpath = "//div[@class='modal-content']//input[@id='inputName']")
	private WebElement SearchBox;
	@FindBy(xpath = "//input[@id='searchPaxBtn']")
	private WebElement SearchBtn;
	@FindBy(xpath = "(//input[@name='paxRadio'])[1]")
	private WebElement FirstResult;
	@FindBy(xpath = "//input[@value='SELECT']")
	private WebElement SelectFirstResult;
	@FindBy(xpath = "//input[@value='Book']")
	private WebElement BookButn;
	@FindBy(xpath = "//div[contains(text(),'No matching records found')]")
	private WebElement selepsngNtFound;
	@FindBy(xpath = "//div[@ id='select-passengers-modal']//button[@class='close']")
	private WebElement CloseSelePsngrPopup;

	@FindBy(id = "meal0_0")
	private WebElement mealP1DrpDwn;
	@FindBy(id = "meal1_0")
	private WebElement mealP2DrpDwn;
	@FindBy(id = "meal2_0")
	private WebElement mealP3DrpDwn;
	@FindBy(id = "baggageId1_0")
	private WebElement selectBaggageP1True;
	@FindBy(id = "baggageId1_1")
	private WebElement selectBaggageP2True;
	@FindBy(id = "baggageId1_2")
	private WebElement selectBaggageP3True;
	@FindBy(id = "bagg_0")
	private WebElement Baggage1DrpDwn;
	@FindBy(id = "bagg_1")
	private WebElement Baggage2DrpDwn;
	@FindBy(id = "bagg_2")
	private WebElement Baggage3DrpDwn;
	@FindBy(xpath = "//input[@value='Book & Hold']")
	private WebElement BookNHold;

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
	@FindBy(xpath = "//a[text()='Select Seat']")
	private WebElement Selectseat;
	@FindBy(xpath = "//h4[text()='Seat Map']")
	private WebElement seatMappopup;
	@FindBy(xpath = "//input[@id='change_0_0']")
	private WebElement selectFirstpassenger;
	@FindBy(xpath="//a[text()='Select Seat']")
	private WebElement Seat;
	@FindBy(id="change_0_0")
	private WebElement Pas1seat;
	@FindBy(id="change_0_1")
	private WebElement Pas2seat;
	@FindBy(id="change_0_2")
	private WebElement Pas3seat;
	@FindBy(xpath="//li[@class='available']")
	private WebElement Availableseat;
	@FindBy(xpath="//a[contains(text(),'CONFIRM & CONTINUE')]")
	private WebElement confirmSeat;
	@FindBy(xpath="//h3[contains(text(),'Return Flight Meal')]")
	private WebElement returnMeal;
	@FindBy(id="mealR0_0")
	private WebElement pas1ReturnMeal;
	@FindBy(id="mealR1_0")
	private WebElement pas2returnMeal;
	@FindBy(id="mealR2_0")
	private WebElement pas3returnmeal;
	@FindBy(xpath="//h3[contains(text(),'Return Flight Baggage')]")
	private WebElement ReturnBaggage;
	@FindBy(id="baggr_0")
	private WebElement Pas1ReturnBagg;
	@FindBy(id="baggr_1")
	private WebElement Pas2ReturnBagg;
	@FindBy(id="baggr_2")
	private WebElement Pas3ReturnBagg;
	

	public PassenegerDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	SoftAssert sa=new SoftAssert();

	public void searchAdultPass(String Adult1, WebDriver driver) throws InterruptedException {
		if (SelectAdultPassengerBtn.isEnabled()) {

			SelectAdultPassengerBtn.click();
			SearchBox.sendKeys(Adult1);
			SearchBtn.click();

			FirstResult.click();
			SelectFirstResult.click();
			System.out.println(" first Adult selected from Select Passenger");
		}
	}

	public void selectPassenger(WebDriver driver) {
		if (SelectAdultPassengerBtn.isEnabled()) {

			SelectAdultPassengerBtn.click();
			SearchBox.sendKeys("9");
			SearchBtn.click();

			FirstResult.click();
			SelectFirstResult.click();
			System.out.println(" first Adult selected from Select Passenger");
		}
	}

	public void selectAdultPassenger2(WebDriver driver) throws InterruptedException {
		WaitStatementLib.explicitWaitForClickable(driver, 20, SelectAdultPassenger2Btn);

		SelectAdultPassenger2Btn.click();
		Thread.sleep(3000);
		SearchBox.sendKeys("8");
		WaitStatementLib.explicitWaitForClickable(driver, 20, SearchBtn);
		SearchBtn.click();

		FirstResult.click();
		SelectFirstResult.click();
		System.out.println(" second Adult selected from Select Passenger");

	}

	public void selectChildPassenger1(WebDriver driver) throws InterruptedException {
		WaitStatementLib.explicitWaitForClickable(driver, 20, SelectChild1PassengerBtn);

		SelectChild1PassengerBtn.click();
		Thread.sleep(3000);
		SearchBox.sendKeys("9");
		WaitStatementLib.explicitWaitForClickable(driver, 20, SearchBtn);
		SearchBtn.click();

		FirstResult.click();
		SelectFirstResult.click();
		System.out.println(" first child selected from Select Passenger");

	}

	// public void selectInfant1Passenger() throws InterruptedException {
	// WaitStatementLib.explicitWaitForClickable(driver, 20,
	// SelectInfant1PassengerBtn);
	//
	// SelectInfant1PassengerBtn.click();
	// Thread.sleep(3000);
	// SearchBox.sendKeys("i");
	// WaitStatementLib.explicitWaitForClickable(driver, 20, SearchBtn);
	// SearchBtn.click();
	//
	// FirstResult.click();
	// SelectFirstResult.click();
	// System.out.println(" first infant selected from Select Passenger");
	// WaitStatementLib.explicitWaitForClickable(driver, 2, InfantAssignTo);
	// InfantAssignTo.click();
	// InfantAssignTo.sendKeys(Keys.ARROW_DOWN);
	// InfantAssignTo.sendKeys(Keys.ENTER);
	//
	// }

//	public void SelectBaggageMealAdult1() throws InterruptedException {
//			mealP1DrpDwn.click();
//			DropdownLib.SelectByTextFromDropdown(driver, mealP1DrpDwn, 1);
//		
//
//		// WaitStatementLib.explicitWaitForClickable(driver, 2,
//		// selectBaggageP1True);
//			selectBaggageP1True.isDisplayed();
//			selectBaggageP1True.click();
//			Thread.sleep(2000);
//			DropdownLib.SelectByTextFromDropdown(driver, Baggage1DrpDwn, 1);
//		
//	}
//
//	public void SelectBaggageMealAdult2() throws InterruptedException {
//			mealP2DrpDwn.click();
//			DropdownLib.SelectByTextFromDropdown(driver, mealP2DrpDwn, 1);
//
//		
//
//			selectBaggageP2True.click();
//			Thread.sleep(3000);
//			DropdownLib.SelectByTextFromDropdown(driver, Baggage2DrpDwn, 1);
//		
//		
//	}
//
//	public void SelectBaggageMealchild1() throws InterruptedException {
//		
//			mealP3DrpDwn.isDisplayed();
//			mealP3DrpDwn.click();
//			DropdownLib.SelectByTextFromDropdown(driver, mealP3DrpDwn, 1);
//		
//
//		
//		
//			selectBaggageP3True.click();
//			Thread.sleep(3000);
//
//			DropdownLib.SelectByTextFromDropdown(driver, Baggage3DrpDwn, 1);
//		
//		
//	}

	public void SelectFlyDubaiBaggageAdult1() {
		
			selectBaggageP1True.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DropdownLib.SelectByTextFromDropdown(driver, Baggage1DrpDwn, 1);
		
	}

	public void SelectFlyDubaiBaggageAdult2() {

			selectBaggageP2True.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DropdownLib.SelectByTextFromDropdown(driver, Baggage2DrpDwn, 1);
		
	}

	public void SelectFlyDubaiBaggagechild1() {
			selectBaggageP3True.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DropdownLib.SelectByTextFromDropdown(driver, Baggage3DrpDwn, 1);
		
	}

	public void ProceedFrBuk() {
		BookButn.click();
	}

	public void bookNhold() {
		if (BookNHold.isEnabled())
			BookNHold.click();
	}

	public String PassengerPageSaveQuote(String passenger) {
		SaveQuote.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		if (SaveQuotePopup.hashCode() != 0) {
			System.out.println("Save Quote Popup is displaying");

			saveQuoteButton.click();
			WaitStatementLib.implicitWaitforSeconds(driver, 30);
			if (QuotationNumber.isDisplayed())
				System.out.println("Quotation saved with number " + QuotationNumber.getText());

		}
		return QuotationNumber.getText();

	}

	public void SSRLCC() {
		Selectseat.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(seatMappopup));
		selectFirstpassenger.click();

	}
	
	public void selectmeal()
	{
		try{
			mealP1DrpDwn.click();
			DropdownLib.SelectByTextFromDropdown(driver, mealP1DrpDwn, 1);
			
			mealP2DrpDwn.click();
			DropdownLib.SelectByTextFromDropdown(driver, mealP2DrpDwn, 1);
			
			mealP3DrpDwn.click();
			DropdownLib.SelectByTextFromDropdown(driver, mealP3DrpDwn, 1);
		}
		catch (Exception e) {
			e.getMessage();
			System.out.println("Meal is not appearing");
		}
		
	}
	public void ReturnMeal() {
		try {
			returnMeal.isDisplayed();
			pas1ReturnMeal.click();
			DropdownLib.SelectByTextFromDropdown(driver, pas1ReturnMeal, 1);
			pas2returnMeal.click();
			DropdownLib.SelectByTextFromDropdown(driver, pas2returnMeal, 1);
			pas3returnmeal.click();
			DropdownLib.SelectByTextFromDropdown(driver, pas3returnmeal, 1);
			System.out.println("Return meal has been selected");
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Return meal is not appearing");

		}
		
	}
	public void selectBaggage() throws InterruptedException {
		try {
			
		
		selectBaggageP1True.click();
		Thread.sleep(3000);
		DropdownLib.SelectByTextFromDropdown(driver, Baggage1DrpDwn, 1);
		selectBaggageP2True.click();
		Thread.sleep(3000);
		DropdownLib.SelectByTextFromDropdown(driver, Baggage2DrpDwn, 1);
		selectBaggageP3True.click();
		Thread.sleep(3000);
		DropdownLib.SelectByTextFromDropdown(driver, Baggage3DrpDwn, 1);
		} catch (Exception e) {
			e.getMessage();
			System.out.println("No Baggage is appearing");

		}
	
	}
	public void ReturnBaggage() {
		try {
			ReturnBaggage.isDisplayed();
			Pas1ReturnBagg.click();
			Thread.sleep(3000);
			DropdownLib.SelectByTextFromDropdown(driver, Pas1ReturnBagg, 1);
			Pas2ReturnBagg.click();
			Thread.sleep(3000);
			DropdownLib.SelectByTextFromDropdown(driver, Pas2ReturnBagg, 1);
			Pas3ReturnBagg.click();
			Thread.sleep(3000);
			DropdownLib.SelectByTextFromDropdown(driver, Pas3ReturnBagg, 1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public void selectSeat() {
		Seat.click();
		WaitStatementLib.explicitWaitForClickable(driver, 1, Pas1seat);
		Pas1seat.click();
		Availableseat.click();
		
		Pas2seat.click();
		Availableseat.click();
		
		Pas3seat.click();
		Availableseat.click();
		confirmSeat.click();
		System.out.println("Seat selected successfully");
	}
}
