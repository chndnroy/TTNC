package satguru.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TTNCLoginPage {
	@FindBy(id="userAlias")
	private WebElement UsernameField;
	@FindBy(id="password")
	private WebElement PasswordField;
	@FindBy(id="login_id")
	private WebElement LoginBtn;
	
	
	public TTNCLoginPage(WebDriver driver) {
PageFactory.initElements(driver, this);	}
	
	public void login(String Username, String Password) {
		UsernameField.sendKeys(Username);
		PasswordField.sendKeys(Password);
		LoginBtn.click();
	}

}
