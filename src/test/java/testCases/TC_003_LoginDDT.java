package testCases;
import utilities.DataProviders;
import pageObjects.LoginPage;
import testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountServicePage;


public class TC_003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String username, String password, String exp_result) {
		
		logger.info("...Staring TC_003_LoginDataDriven Test...");
		try {
		LoginPage lp= new LoginPage(driver);
		
		
		logger.info("...Providing Login info...");
		
		
		lp.getPassword(rb.getString(username));  //will get values from config.properties
		lp.getUsername(rb.getString(password));
		lp.clickLogin();
		logger.info("... Clicking Login button...");
		
		AccountServicePage acs= new AccountServicePage(driver);
		boolean targetPage= acs.getConfirmationMsg();
		if(exp_result.equals("Valid")) {
			if(targetPage==true) {
				acs.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp_result.equals("Invalid")) {
			if(targetPage==true) {
				acs.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("...TC_003 Login Data Driven Completed");
	}

}
