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
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;

public class OnewayFlightTest extends LoginTest {
	@Test(priority = 1)
	public void OnewatTckt() throws InterruptedException {

		TTNCLoginPage blp = new TTNCLoginPage(driver);
		blp.login(ExcelUtils.readData("Sheet1", 7, 1), ExcelUtils.readData("Sheet1", 8, 1));

		assertEquals("Satguru", driver.getTitle(), "Login not verified");
		System.out.println("TTNC login is successful");

		BasePage bp = new BasePage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		bp.booking(driver);
		bp.BranchBooking(driver);
		FlightPage fp = new FlightPage(driver);
		Thread.sleep(3000);
		// fp.Flight();

		fp.Onewayinput(ExcelUtils.readData("Sheet3", 0, 1), ExcelUtils.readData("Sheet3", 1, 1));
		System.out.println("Oneway input is successful");
		Flightresult fr = new Flightresult(driver);
		// owr.airlineSearch(ExcelUtils.readData("Sheet3", 1, 2));
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fr.book(driver);
		System.out.println("Book button clicked on Search result page");
		Thread.sleep(10000);
		CrossSellingPage csp = new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		csp.noThanks();
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fdp.OnewaydetailPage();
		PassenegerDetailsPage pdp = new PassenegerDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1), driver);
		System.out.println("Passenger selected from Select passenger");
		Thread.sleep(5000);
		pdp.ProceedFrBuk();
		PaymentPage pp = new PaymentPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pp.CreditCardPay(driver);
		System.out.println("CreditCard payment is done");
		ConfirmationPage cp = new ConfirmationPage(driver);
		Thread.sleep(10000);
		cp.ConfirmBooking();
	}
	// @Test(priority=0)
	// public void OnewayTcktUsingCreditCard() throws InterruptedException
	// {
	// PortalLogin pl=new PortalLogin(driver);
	// pl.sendLogin(ExcelUtils.readData("Sheet2", 1, 0),
	// ExcelUtils.readData("Sheet2", 1, 1),ExcelUtils.readData("Sheet2", 1, 2));
	// pl.Flight();
	// System.out.println("Portal login is successful");
	// FlightPage fp=new FlightPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// fp.Onewayinput(ExcelUtils.readData("Sheet3", 1, 0),
	// ExcelUtils.readData("Sheet3", 1, 1));
	// System.out.println("Oneway input is successful");
	// Flightresult fr=new Flightresult(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// fr.book();
	// System.out.println("Book button clicked on Search result page");
	//
	// CrossSellingPage csp=new CrossSellingPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// csp.noThanks();
	// FlightDetailsPage fdp=new FlightDetailsPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// fdp.clickContinue();
	// PassenegerDetailsPage pdp=new PassenegerDetailsPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 1, 3));
	// System.out.println("Passenger selected from Select passenger");
	// Thread.sleep(5000);
	// pdp.ProceedFrBuk();
	// PaymentPage pp=new PaymentPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// pp.CreditCardPay(driver, ExcelUtils.readData("Sheet3", 1, 13),
	// ExcelUtils.readData("Sheet3", 1, 14),
	// ExcelUtils.readData("Sheet3", 1, 15),
	// ExcelUtils.readData("Sheet3", 1, 16),
	// ExcelUtils.readData("Sheet3", 1, 17));
	// System.out.println("Credit card payment has been done");
	// ConfirmationPage cp=new ConfirmationPage(driver);
	//
	// }

}
