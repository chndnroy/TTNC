package satguru.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Portal.Pageobjects.flights.ConfirmationPage;
import Portal.Pageobjects.flights.CrossSellingPage;
import Portal.Pageobjects.flights.FlightDetailsPage;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import Portal.Pageobjects.flights.PassenegerDetailsPage;
import Portal.Pageobjects.flights.PaymentPage;
import satguru.generic.ExcelUtils;
import satguru.generic.FullpageScreenshot;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;


public class FlightPlusInsuranceTest extends LoginTest {
	@Test
	public void RoundtripTckt() throws Exception {
		TTNCLoginPage blp=new TTNCLoginPage(driver);
		blp.login(ExcelUtils.readData("Sheet1", 7,1), ExcelUtils.readData("Sheet1", 8,1));
		
		assertEquals("Satguru",driver.getTitle(),"Login not verified" );
		System.out.println("TTNC login is successful");
		
		BasePage bp=new BasePage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		bp.booking(driver);
		bp.BranchBooking(driver);
		FlightPage fp = new FlightPage(driver);
		System.out.println("Flight page is open");
		Thread.sleep(3000);
		fp.RoundtripPage();
		
		System.out.println("Flight page is open");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fp.RoundtripPage();
		System.out.println("Roundtrip Page is open");
		fp.RoundTripInput(ExcelUtils.readData("Sheet3", 5, 1), ExcelUtils.readData("Sheet3", 6, 1));
		fp.preferredAirlineRoundtripselect("jet airways");
		Flightresult fr = new Flightresult(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 4);
		fr.book(driver);
		System.out.println("FLight Result page is open");
		CrossSellingPage csp = new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		csp.noThanks();
		System.out.println("Cross selling page is open");
		FlightDetailsPage fdp = new FlightDetailsPage(driver);

		fdp.FLightNInsurance(driver);
		System.out.println("Flight + Insurance details page is open");
		PassenegerDetailsPage pdp = new PassenegerDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1), driver);
		System.out.println("Passenger selected from Select passenger");
		Thread.sleep(5000);
        pdp.ProceedFrBuk();
        PaymentPage pp=new PaymentPage(driver);
        pp.CreditCardPay(driver);
        ConfirmationPage cp=new ConfirmationPage(driver);
        WaitStatementLib.implicitWaitforSeconds(driver, 30);
        cp.ConfirmBooking();
        FullpageScreenshot f=new FullpageScreenshot();
		f.takescreenshot(driver);
	}
}
