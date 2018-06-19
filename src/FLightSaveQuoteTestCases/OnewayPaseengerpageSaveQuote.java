package FLightSaveQuoteTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import Portal.Pageobjects.flights.CrossSellingPage;
import Portal.Pageobjects.flights.FlightDetailsPage;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import Portal.Pageobjects.flights.PassenegerDetailsPage;
import satguru.generic.ExcelUtils;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;
import satguru.scripts.LoginTest;

public class OnewayPaseengerpageSaveQuote extends LoginTest {
	@Test
	public void saveQuote() throws Exception
	{
		
		
		TTNCLoginPage blp=new TTNCLoginPage(driver);
		blp.login(ExcelUtils.readData("Sheet1", 7,1), ExcelUtils.readData("Sheet1", 8,1));
		
		assertEquals("Satguru",driver.getTitle(),"Login not verified" );
		System.out.println("TTNC login is successful");
		
		BasePage bp=new BasePage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		bp.booking(driver);
		bp.BranchBooking(driver);
		FlightPage fp=new FlightPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		
		fp.Onewayinput(ExcelUtils.readData("Sheet3", 0, 1), ExcelUtils.readData("Sheet3", 1, 1));
		System.out.println("Oneway input is successful");
		Flightresult fr=new Flightresult(driver);
//        owr.airlineSearch(ExcelUtils.readData("Sheet3", 1, 2));
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
         fr.book(driver);   
         System.out.println("Book button clicked on Search result page");
         CrossSellingPage csp=new CrossSellingPage(driver);
        
         csp.noThanks();
         FlightDetailsPage fdp=new FlightDetailsPage(driver);
 		Thread.sleep(5000);
         fdp.OnewaydetailPage();
         PassenegerDetailsPage pdp=new PassenegerDetailsPage(driver);
  		WaitStatementLib.implicitWaitforMinutes(driver, 2);
        pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1),driver);
        System.out.println("Passenger selected from Select passenger");
        Thread.sleep(5000);
       String b = pdp.PassengerPageSaveQuote("c");
       ExcelUtils.writeData("Sheet3", 12,3, b);

}
}
