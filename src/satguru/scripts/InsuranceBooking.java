package satguru.scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Portal.Pageobjects.Insurance.INSSearchresultPage;
import Portal.Pageobjects.Insurance.InsuranceConfirmationPage;
import Portal.Pageobjects.Insurance.InsuranceDetailsPage;
import Portal.Pageobjects.Insurance.InsuranceSearchPage;
import Portal.Pageobjects.Insurance.PassengerDetailsPage;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.PaymentPage;
import satguru.generic.ExcelUtils;
import satguru.generic.WaitStatementLib;
import satguru.pageobjects.BasePage;
import satguru.pageobjects.TTNCLoginPage;

public class InsuranceBooking extends LoginTest {

	@Test
	public void InsuranceTest() throws InterruptedException{
	TTNCLoginPage blp=new TTNCLoginPage(driver);
	blp.login(ExcelUtils.readData("Sheet1", 7,1), ExcelUtils.readData("Sheet1", 8,1));	
	assertEquals("Satguru",driver.getTitle(),"Login not verified" );
	System.out.println("TTNC login is successful");
	
	BasePage bp=new BasePage(driver);
	WaitStatementLib.implicitWaitforSeconds(driver, 10);
	bp.booking(driver);
	bp.BranchBooking(driver);
	Thread.sleep(5000);
	bp.Insurance();
	InsuranceSearchPage isp = new InsuranceSearchPage(driver);
	System.out.println("Insurance page is open");
	WaitStatementLib.implicitWaitforMinutes(driver, 2);
	isp.Insuranceinput(ExcelUtils.readData("Sheet2", 0, 1), ExcelUtils.readData("Sheet2", 1, 1),
			ExcelUtils.readData("Sheet2", 2, 1));
	INSSearchresultPage isrp=new INSSearchresultPage(driver);
	isrp.GadgetInsurance(driver);
	InsuranceDetailsPage id=new InsuranceDetailsPage(driver);
	WaitStatementLib.implicitWaitforSeconds(driver, 10);
	id.clickContinue();
	PassengerDetailsPage pdp=new PassengerDetailsPage(driver);
	WaitStatementLib.implicitWaitforSeconds(driver, 10);
	pdp.selectPassenger(ExcelUtils.readData("Sheet3", 3, 1));
	pdp.ProceedFrBuk();
	PaymentPage pp=new PaymentPage(driver);
	WaitStatementLib.implicitWaitforSeconds(driver, 10);
	pp.CreditCardPay(driver);
	InsuranceConfirmationPage icp=new InsuranceConfirmationPage(driver);
	WaitStatementLib.implicitWaitforSeconds(driver, 10);
	icp.ConfirmBooking();


	}
}

