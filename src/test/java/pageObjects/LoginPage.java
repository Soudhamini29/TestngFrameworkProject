package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		}

	@FindBy(name="username")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/form/div[3]/input")
	WebElement btnLogin;
	public void getUsername(String un) {
		txtUsername.sendKeys(un);
		
	}
	public void getPassword(String pw) {
		txtPassword.sendKeys(pw);
	}
	public void clickLogin() {
		btnLogin.click();
	}
}
