package satguru.scripts;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import Portal.Pageobjects.flights.PaymentPage;
import Portal.Pageobjects.hotels.HotelCrossSellingPathPage;
import Portal.Pageobjects.hotels.HotelDetailsPage;
import Portal.Pageobjects.hotels.HotelInfoPage;
import Portal.Pageobjects.hotels.HotelPassengerDetailsPage;
import Portal.Pageobjects.hotels.HotelSearchPage;
import Portal.Pageobjects.hotels.Hotelresultspage;
import satguru.generic.ExcelUtils;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;

public class HotelTest extends LoginTest {
	@Test
	public void HotelBook() throws InterruptedException {
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
		Hotelresultspage hrp = new Hotelresultspage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
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
		hip.ClikOnBukBtn(driver);
		System.out.println("Book button clicked on info page");
		HotelDetailsPage hdp = new HotelDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		hdp.clickOnContinue();
		System.out.println("Details page is open");
		HotelCrossSellingPathPage hcsp = new HotelCrossSellingPathPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		hcsp.ClickOnNoThanksBtn();
		HotelPassengerDetailsPage hpdp = new HotelPassengerDetailsPage(driver);
		hpdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1), driver);
		PaymentPage pp = new PaymentPage(driver);
		System.out.println("Payment page is open");
		pp.CreditCardPay(driver);

	}

}
