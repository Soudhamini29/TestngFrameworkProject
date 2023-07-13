package testCases;
import pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountServicePage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity", "Master"})
    public void test_Login() {
		logger.info("...Executing Login Test...");
		try {
			
		LoginPage lp= new LoginPage(driver);
		logger.info("...Providing Login info...");
		lp.getPassword(rb.getString("username"));  //will get values from config.properties
		lp.getUsername(rb.getString("password"));
		logger.info("Clicked on Login button");
		lp.clickLogin();
		AccountServicePage acs= new AccountServicePage(driver);
		boolean targetPage= acs.getConfirmationMsg();
		
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("...Execution completed for Login Test...");
	}
}
