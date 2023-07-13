package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegister extends BasePage{

	public AccountRegister(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="customer.firstName")
	WebElement txtFirstname;
	
	@FindBy(name="customer.lastName")
	WebElement txtLastname;
	
	@FindBy(name="customer.address.street")
	WebElement address;
	
	@FindBy(name="customer.address.city")
	WebElement city;
	
	@FindBy(name="customer.address.state")
	WebElement state;
	
	@FindBy(name="customer.address.zipCode")
	WebElement zipcode;
	
	@FindBy(name="customer.phoneNumber")
	WebElement phoneno;
	
	@FindBy(name="customer.ssn")
	WebElement ssn;
	
	@FindBy(name="customer.username")
	WebElement userName;
	
	@FindBy(name="customer.password")
	WebElement txtPassword;
	
	@FindBy(name="repeatedPassword")
	WebElement confirmPassword;
	
	@FindBy(xpath="//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
	WebElement btnRegister;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/p")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	public void setAddress(String street) {
		address.sendKeys(street);
	}
	public void setCity(String cusCity) {
		city.sendKeys(cusCity);
	}
	
	public void setState(String cusState) {
		state.sendKeys(cusState);
	}
	public void setCode(String cusCode) {
		zipcode.sendKeys(cusCode);
	}
	
	public void setPhoneNo(String cusPhone) {
		phoneno.sendKeys(cusPhone);
	}
	
	public void setSsn(String cusSsn) {
		ssn.sendKeys(cusSsn);
	}
	
	public void setUserName(String cusUsername) {
		userName.sendKeys(cusUsername);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String cusPwd) {
		confirmPassword.sendKeys(cusPwd);
	}	
		
	public void clickRegsiter() {
		btnRegister.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

}
