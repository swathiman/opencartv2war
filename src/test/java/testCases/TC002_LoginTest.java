package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public void verifyLogin() {
		logger.info("**** Starting   TC001_LoginTest  ****");
		try {
			
			HomePage homePage = new HomePage(driver);
			homePage.clickOnMyAccount();
			logger.info("clicked on my account link");
			homePage.clickOnLogin();
			logger.info("clicked on login link");
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(p.getProperty("email"));
			logger.info("got email from config properties file");
			loginPage.setPassword(p.getProperty("password"));
			logger.info("got password from config properties file");
			loginPage.clickOnLogin();
			
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			Assert.assertTrue(myAccountPage.isMyAccountPageExists());
			logger.info("####  Login Successful  ####");
			
		} catch (Exception e) {
			logger.error("verifyLogin::",e);
			Assert.fail();
		}
		logger.info("**** finished   TC001_LoginTest  ****");

	}
}
