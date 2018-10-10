package Portal.scripts.creditcard;

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
import satguru.scripts.LoginTest;

public class MulticityCreditCard extends LoginTest {
	@Test
	private void MulticityTckt() throws InterruptedException {
		TTNCLoginPage blp=new TTNCLoginPage(driver);
		blp.login(ExcelUtils.readData("Sheet1", 7,1), ExcelUtils.readData("Sheet1", 8,1));
		
		assertEquals("Satguru",driver.getTitle(),"Login not verified" );
		System.out.println("TTNC login is successful");
		
		BasePage bp=new BasePage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		bp.booking(driver);
		bp.BranchBooking(driver);
		Thread.sleep(4000);
		FlightPage fp = new FlightPage(driver);
		fp.MulticityPage();
		System.out.println("Flight page is open");
		fp.MulticityPage();
		System.out.println("Multicity page is open");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fp.multicityinput(ExcelUtils.readData("Sheet3", 7, 1), ExcelUtils.readData("Sheet3", 8, 1),
				ExcelUtils.readData("Sheet3", 9, 1), ExcelUtils.readData("Sheet3", 10, 1));
		Flightresult fr = new Flightresult(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 4);
		fr.book(driver);
		System.out.println("Multicity search results is open");
		CrossSellingPage csp = new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		csp.noThanks();
		System.out.println("Cross selling page is open");
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fdp.OnewaydetailPage();
		System.out.println("Flight details page is open");
		PassenegerDetailsPage pdp = new PassenegerDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1), driver);
		Thread.sleep(2000);

		pdp.ProceedFrBuk();
		System.out.println("Passenger details is selected from Select passenger");
		PaymentPage pp = new PaymentPage(driver);
		System.out.println("Payment page is open");
		pp.CreditCardPay(driver);
		ConfirmationPage cp = new ConfirmationPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 1);
		cp.ConfirmBooking();

	}
}
