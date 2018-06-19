package HotelSaveQuoteTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Portal.Pageobjects.hotels.HotelSearchPage;
import Portal.Pageobjects.hotels.Hotelresultspage;
import satguru.generic.ExcelUtils;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;
import satguru.scripts.LoginTest;

public class HotelresultsPageSaveQuote extends LoginTest {
	@Test
	public void HotelBook() throws Exception {
		TTNCLoginPage blp = new TTNCLoginPage(driver);
		blp.login(ExcelUtils.readData("Sheet1", 7, 1), ExcelUtils.readData("Sheet1", 8, 1));

		assertEquals("Satguru", driver.getTitle(), "Login not verified");
		System.out.println("TTNC login is successful");

		BasePage bp = new BasePage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		bp.booking(driver);
		bp.BranchBooking(driver);
		Thread.sleep(5000);
		bp.Hotel();
		HotelSearchPage hsp = new HotelSearchPage(driver);
		hsp.Hotelsearch(ExcelUtils.readData("Sheet4", 0, 1), ExcelUtils.readData("Sheet4", 1, 1));
		System.out.println("Hotel input is successful");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		Hotelresultspage hrp=new Hotelresultspage(driver);
		String b = hrp.SaveQuote("chandan");
		ExcelUtils.writeData("Sheet4", 3, 1, b);

}
}
