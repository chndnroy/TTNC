package HotelSaveQuoteTestCases;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import Portal.Pageobjects.hotels.HotelInfoPage;
import Portal.Pageobjects.hotels.HotelSearchPage;
import Portal.Pageobjects.hotels.Hotelresultspage;
import satguru.generic.ExcelUtils;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;
import satguru.scripts.LoginTest;

public class HotelInfoSaveQuote extends LoginTest {
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
		Hotelresultspage hrp = new Hotelresultspage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 10);
		hrp.ClickOnBukBtn();
		System.out.println("Book button clicked on results page");
		String parent = driver.getWindowHandle();
		System.out.println("control is on page " + driver.getTitle());
		Set<String> a = driver.getWindowHandles();
		Iterator<String> child = a.iterator();
		String c1 = child.next();
		String c2 = child.next();
		driver.switchTo().window(c2);

		System.out.println("Info page is open");
		HotelInfoPage hip = new HotelInfoPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		String b = hip.SaveQuote("c");
		ExcelUtils.writeData("Sheet4", 4, 1, b);
}
}
