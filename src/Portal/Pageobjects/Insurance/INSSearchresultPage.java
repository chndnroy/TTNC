package Portal.Pageobjects.Insurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import satguru.generic.DropdownLib;
import satguru.generic.WaitStatementLib;



public class INSSearchresultPage {
	@FindBy(xpath = "//strong[contains(text(),'Gadget Insurance')]/..//input")
	private WebElement GadgetINSoption;
	@FindBy(xpath = "//select[@data-ng-model='selectedGadgetProduct.product[$index]']")
	private WebElement SelectGadgetINS;
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement ContinueBtn;

	public INSSearchresultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void GadgetInsurance(WebDriver driver) throws InterruptedException {
		GadgetINSoption.click();
		Thread.sleep(2000);
		SelectGadgetINS.click();
		DropdownLib.SelectByTextFromDropdown(driver, SelectGadgetINS, 1);
		System.out.println("Gadget Insurance has been selected from dropdown");
		WaitStatementLib.implicitWaitforSeconds(driver, 5);

		ContinueBtn.click();
		System.out.println("Insurance details page has been open");

	}
}
