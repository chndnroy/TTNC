package FLightSaveQuoteTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import satguru.generic.ExcelUtils;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;
import satguru.scripts.LoginTest;

public class RoundtripResultsSaveQuote extends LoginTest{
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
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fp.RoundtripPage();
		System.out.println("Roundtrip Page is open");
		fp.RoundTripInput(ExcelUtils.readData("Sheet3", 5, 1), ExcelUtils.readData("Sheet3", 6, 1));
		Flightresult fr = new Flightresult(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 4);
		String b = fr.resultsPagesSavequote("chandan");
		ExcelUtils.writeData("Sheet3", 13, 1, b);

}
}
