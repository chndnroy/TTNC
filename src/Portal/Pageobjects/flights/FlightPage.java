package Portal.Pageobjects.flights;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import satguru.generic.DropdownLib;


public class FlightPage {

	@FindBy(xpath = "//li[contains(text(),'One Way')]")
	private WebElement onewayBtn;

	@FindBy(xpath = "//li[contains(text(),'Round')]")
	private WebElement roundtripBtn;
	@FindBy(xpath = "//li[contains(text(),'Multi')]")
	private WebElement multicityBtn;
	@FindBy(xpath = "(//p[contains(text(),'Advanced Search')])[1]")
	private WebElement advanceSearchOnewayBtn;

	@FindBy(xpath = "(//p[contains(text(),'Advanced Search')])[2]")
	private WebElement advanceSearchRoundtripBtn;
	@FindBy(id = "preffered")
	private WebElement PreferredOneway;
	@FindBy(id = "roundPreff")
	private WebElement roundPreff;
	@FindBy(id = "roundPreff")
	private WebElement prefferedRound;

	public FlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void OnewayPage() {
		onewayBtn.click();

	}

	public void RoundtripPage() throws InterruptedException {
		roundtripBtn.click();
		// advanceSearchBtn.click();
		// prefferedRound.sendKeys(airline);
		// Thread.sleep(3000);
		// prefferedRound.sendKeys(Keys.ARROW_DOWN);
		// prefferedRound.sendKeys(Keys.ENTER);

	}

	public void MulticityPage() {
		multicityBtn.click();

	}

	int date;
	@FindBy(id = "startingFrom_1")
	private WebElement OnewayOrigin;
	@FindBy(id = "goingTo_1")
	private WebElement OnewayDest;

	@FindBy(id = "startingFrom_2")
	private WebElement RoundOrigin;
	@FindBy(id = "goingTo_2")
	private WebElement RoundDest;
	@FindBy(id = "dateofjourney_1")
	private WebElement ROriginCal;
	@FindBy(id = "dateofjourney_2")
	private WebElement RReturnCal;
	@FindBy(xpath = "// div[@id='round-trip']//input[@value='SEARCH']")
	private WebElement RoundsearchBtn;

	@FindBy(id = "startingFrom_4")
	private WebElement Multiorigin1;
	@FindBy(id = "goingTo_4")
	private WebElement MDest1;
	@FindBy(id = "goingTo_5")
	private WebElement MDest2;
	@FindBy(id = "goingTo_6")
	private WebElement MDest3;
	@FindBy(id = "goingTo_7")
	private WebElement MDest4;
	@FindBy(id = "goingTo_8")
	private WebElement MDest5;
	@FindBy(xpath = "//div[contains(text(),'Add')]")
	private WebElement AddMoreCityBtn;
	@FindBy(id = "dateOfJourney_3")
	private WebElement MCcalender1;
	@FindBy(id = "dateOfJourney_4")
	private WebElement MCcalender2;
	@FindBy(id = "dateOfJourney_5")
	private WebElement MCcalender3;
	@FindBy(id = "dateOfJourney_5")
	private WebElement MCcalender4;
	@FindBy(id = "dateOfJourney_6")
	private WebElement MCcalender5;
	@FindBy(xpath = "// div[@id='multi-city']//input[@value='SEARCH']")
	private WebElement multisearchBtn;

	@FindBy(id = "datePicker_1")
	private WebElement OnewayCalender;
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement NxtMnthBtn;
	@FindBy(xpath = "//a[text()=11]")
	private WebElement selectdate1;
	@FindBy(xpath = "//a[text()='15']")
	private WebElement selectdate2;
	@FindBy(xpath = "//a[text()='18']")
	private WebElement selectdate3;
	@FindBy(xpath = "//a[text()='20']")
	private WebElement selectdate4;
	@FindBy(xpath = "//a[text()='22']")
	private WebElement selectdate5;

	@FindBy(id = "flightwidgetElement0.cabinClass")
	private WebElement OnewayClassDRPDWN;
	@FindBy(id = "noOfAdults")
	private WebElement adultDrpDwn;
	@FindBy(id = "noOfAdultsr")
	private WebElement adultDrpDwnR;
	@FindBy(id = "noOfChilds")
	private WebElement childDrpDwn;
	@FindBy(id = "noOfChildsr")
	private WebElement childDrpDwnR;
	@FindBy(id = "noOfInfants")
	private WebElement infantDrpDwn;

	@FindBy(xpath = "// div[@id='one-way']//input[@value='SEARCH']")
	private WebElement OnewaySearchBtn;

	@FindBy(xpath = "(//a[contains(text(),'Book')])[1]")
	private WebElement Bookbtn;
	@FindBy(xpath = "//li//div[text()='Air Arabia']")
	private WebElement PreffAirArabia;
	@FindBy(xpath = "//div[text()='FLYDUBAI']")
	private WebElement PreffFlydubai;
	@FindBy(xpath = "//div[text()='IndiGo Airlines']")
	private WebElement PreffIndigo;
	@FindBy(xpath = "//div[text()='Spicejet']")
	private WebElement PreffSpicejet;
	@FindBy(xpath="//div[text()='Jet airways']")
	private WebElement PreffJetAirways;

	// General input in case of Oneway input

	public void Onewayinput(String origincity, String destcity) throws InterruptedException {
		OnewayOrigin.sendKeys(origincity);
		Thread.sleep(2000);
		OnewayOrigin.sendKeys(Keys.ENTER);
		OnewayDest.sendKeys(destcity);
		Thread.sleep(2000);
		OnewayDest.sendKeys(Keys.ENTER);

		OnewayCalender.click();
		NxtMnthBtn.click();
		selectdate1.click();
		OnewaySearchBtn.click();
	}

	// Scenario including 2 Adult, 1 child and 1 Infant
	// =======================================================================

	public void Scenario1Oneway(String origincity, String destcity) throws InterruptedException {
		OnewayOrigin.sendKeys(origincity);
		Thread.sleep(2000);
		OnewayOrigin.sendKeys(Keys.ENTER);
		OnewayDest.sendKeys(destcity);
		Thread.sleep(2000);
		OnewayDest.sendKeys(Keys.ENTER);

		OnewayCalender.click();
		NxtMnthBtn.click();
		selectdate1.click();
		// Advance search option
		advanceSearchOnewayBtn.click();
	}
	// =======================================================================

	public void RoundTripInput(String origin, String dest) throws InterruptedException {

		RoundOrigin.sendKeys(origin);
		Thread.sleep(2000);
		RoundOrigin.sendKeys(Keys.ENTER);
		ROriginCal.click();
		NxtMnthBtn.click();
		selectdate1.click();

		RoundDest.sendKeys(dest);
		Thread.sleep(2000);
		RoundDest.sendKeys(Keys.ENTER);
		// RReturnCal.click();
		// selectdate2.click();
		advanceSearchRoundtripBtn.click();
	
	}
	// =======================================================================

	// Preferred Airline Oneway select
	public void preferredAirlineselect(String airline) throws InterruptedException {
		PreferredOneway.sendKeys(Keys.ENTER);

		PreferredOneway.sendKeys(airline);
		Thread.sleep(3000);
		PreferredOneway.sendKeys(Keys.ENTER);

		System.out.println("preferred airline "+airline+" has been selected");

	}
	// =======================================================================

	// Preferred Airline Oneway select
	public void preferredAirlineRoundtripselect(String airline) throws InterruptedException {
		prefferedRound.sendKeys(airline);
		Thread.sleep(3000);
		
		prefferedRound.sendKeys(Keys.ENTER);
		System.out.println("preferred airline has been selected");
		RoundsearchBtn.click();
		

	}

	// =======================================================================
	public void preferredRoundAirlineselect(String airline) throws InterruptedException {
		prefferedRound.sendKeys(Keys.ENTER);
		prefferedRound.sendKeys(airline);
		Thread.sleep(3000);
		if (airline.equalsIgnoreCase("FLYDUBAI"))
		{
			PreffFlydubai.click();
		}
		else if (airline.equalsIgnoreCase("Air Arabia")) {
			PreffAirArabia.click();
			
		}
		else if (airline.equalsIgnoreCase("Indigo")) {
			PreffIndigo.click();
			
		}
		else if (airline.equalsIgnoreCase("spicejet")) {
			PreffSpicejet.click();
			
		}
		else if (airline.equalsIgnoreCase("jet airways")) {
			PreffJetAirways.click();
			
		}

			
		System.out.println("preferred airline"+airline+" has been selected");
		Thread.sleep(2000);
		RoundsearchBtn.click();


	}
	// =======================================================================

	public void preferredAirArabia(String airline) throws InterruptedException {
		PreferredOneway.sendKeys(Keys.ENTER);
		PreferredOneway.sendKeys(airline);
		Thread.sleep(3000);
		PreffAirArabia.click();
		System.out.println("preferred airline Airarabia has been selected");

	}
	// =======================================================================

	public void preferredRoundAirArabia(String airline) throws InterruptedException {
		prefferedRound.sendKeys(airline);
		Thread.sleep(3000);
		PreffAirArabia.click();
		System.out.println("preferred airline Airarabia has been selected");

	}
	// =======================================================================

	// Selection of passenger combination from Dropdown
	public void PassengerCombination1(WebDriver driver) {
		DropdownLib.Choosebytext(driver, adultDrpDwn, "2");
		DropdownLib.Choosebytext(driver, childDrpDwn, "1");
		// DropdownLib.Choosebytext(driver, infantDrpDwn, "1");
		System.out.println("2 Adult, 1 Child and 1 Infant has been selected ");
		OnewaySearchBtn.click();

	}

	public void PassengerRoundCombination1(WebDriver driver) {
		DropdownLib.Choosebytext(driver, adultDrpDwnR, "2");
		DropdownLib.Choosebytext(driver, childDrpDwnR, "1");
		// DropdownLib.Choosebytext(driver, infantDrpDwn, "1");
		System.out.println("2 Adult, 1 Child and 1 Infant has been selected ");
		RoundsearchBtn.click();

	}
	// =======================================================================

	public void book(WebDriver driver) {
		Bookbtn.click();
	}

	// =======================================================================

	public void RoundTripLCCInput(String origin, String dest) throws InterruptedException {

		RoundOrigin.sendKeys(origin);
		Thread.sleep(2000);
		RoundOrigin.sendKeys(Keys.ENTER);
		ROriginCal.click();
		NxtMnthBtn.click();
		selectdate2.click();

		RoundDest.sendKeys(dest);
		Thread.sleep(2000);
		RoundDest.sendKeys(Keys.ENTER);
		advanceSearchRoundtripBtn.click();

	}
	// =======================================================================

	public void multicityinput(String Origin1, String Dest1, String Dest2, String Dest3) throws InterruptedException {
//		AddMoreCityBtn.click();
		Multiorigin1.sendKeys(Origin1);
		Thread.sleep(5000);
		Multiorigin1.sendKeys(Keys.ENTER);

		MDest1.sendKeys(Dest1);
		Thread.sleep(5000);
		MDest1.sendKeys(Keys.ENTER);

		MCcalender1.click();
		NxtMnthBtn.click();
		selectdate1.click();

		MDest2.sendKeys(Dest2);
		Thread.sleep(5000);
		MDest2.sendKeys(Keys.ENTER);

		MCcalender2.click();
		selectdate2.click();

//		MDest3.sendKeys(Dest3);
//		Thread.sleep(5000);
//		MDest3.sendKeys(Keys.ENTER);
//
//		MCcalender3.click();
//		selectdate3.click();
		multisearchBtn.click();

	}
}
