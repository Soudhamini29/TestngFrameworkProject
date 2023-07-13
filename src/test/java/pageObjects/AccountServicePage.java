package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountServicePage extends BasePage{

	public AccountServicePage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath="//*[@id=\"rightPanel\"]/div/div/h1")
WebElement txtLoginmsg;
@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[8]/a")
WebElement btnLogout;

public boolean getConfirmationMsg() {
	try {
		return (txtLoginmsg.isDisplayed());
	}
	catch(Exception e) {
		return false;
	}
}
	
public void clickLogout() {

	btnLogout.click();
}

}
