package Portal.Pageobjects.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelCrossSellingPathPage {
	@FindBy(xpath="//a[contains(text(),'NO THANKS')]")
	private WebElement NoThanksBtn;
	
	public HotelCrossSellingPathPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}

	public void ClickOnNoThanksBtn() {
		NoThanksBtn.click();
		
	}
}
