package FLightSaveQuoteTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import Portal.Pageobjects.flights.CrossSellingPage;
import Portal.Pageobjects.flights.FlightDetailsPage;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import satguru.generic.ExcelUtils;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;
import satguru.scripts.LoginTest;

public class OnewayDetailPageSaveQuote extends LoginTest{
	@Test
	public void OnewatTckt() throws Exception {
		TTNCLoginPage blp=new TTNCLoginPage(driver);
		blp.login(ExcelUtils.readData("Sheet1", 7,1), ExcelUtils.readData("Sheet1", 8,1));
		
		assertEquals("Satguru",driver.getTitle(),"Login not verified" );
		System.out.println("TTNC login is successful");
		
		BasePage bp=new BasePage(driver);
		satguru.generic.WaitStatementLib.implicitWaitforSeconds(driver, 10);
		bp.booking(driver);
		bp.BranchBooking(driver);
		FlightPage fp=new FlightPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		
		fp.Onewayinput(ExcelUtils.readData("Sheet3", 0, 1), ExcelUtils.readData("Sheet3", 1, 1));
		System.out.println("Oneway input is successful");
		Flightresult fr=new Flightresult(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fr.book(driver);
		CrossSellingPage csp=new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		csp.noThanks();
		FlightDetailsPage fdp=new FlightDetailsPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		String b = fdp.DetailPageSaveQuote("chandan");
		ExcelUtils.writeData("Sheet3", 13, 1, b);
}
}
