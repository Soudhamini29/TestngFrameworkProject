package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.AccountRegister;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest  extends BaseClass{
	@Test(groups = {"Regression", "Master"})
	void test_account_Registration() {
		try {
		HomePage hp= new HomePage(driver);
		logger.debug("application logs...");
		logger.info("*** Starting the execution of TC_001_AccountRegistrationTest ***");
		hp.clickRegister();
		
		logger.info("Clicked on Register");
		AccountRegister ar=new AccountRegister(driver);
		
		
		ar.setFirstName(randomString().toUpperCase());
		ar.setLastName(randomString().toUpperCase());
		
		ar.setAddress(randomString());
		ar.setCity(randomString());
		ar.setState(randomString());
		ar.setCode(randomNumber1());
		ar.setPhoneNo(randomNumber());
		ar.setSsn(randomString());
		//ar.setUserName(randomString());
		String password=randomAlphaNumeric();
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		logger.info("Customer Details are filled");
		ar.clickRegsiter();
		logger.info("Submit is clicked");
		Thread.sleep(5000);
		String confmsg=ar.getConfirmationMsg();
		logger.info("Confirmation msg is verified");
		Assert.assertEquals(confmsg, "Your account was created successfully. You are now logged in.","TestFailed");
		}
		catch(Exception e) {
			Assert.fail();
			logger.error("Test failed");
		}
	}

}
