package satguru.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TTNCLoginPage {
	@FindBy(id="userAlias")
	private WebElement UsernameField;
	@FindBy(id="password_password")
	private WebElement PasswordField;
	@FindBy(id="login_id")
	private WebElement LoginBtn;
	
	
	public TTNCLoginPage(WebDriver driver) {
PageFactory.initElements(driver, this);	}
	
	public void login(String Username, String Password) {
		UsernameField.sendKeys(Password);
		UsernameField.sendKeys(Keys.CONTROL+"a");
		UsernameField.sendKeys(Keys.CONTROL+"x");

		PasswordField.sendKeys(Keys.CONTROL+"v");
		UsernameField.sendKeys(Username);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		LoginBtn.click();
	}

}
