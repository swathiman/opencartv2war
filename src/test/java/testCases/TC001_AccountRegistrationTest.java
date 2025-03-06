package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verifyAccountRegistration() {
		logger.info("*********** Starting TC001_AccountRegistrationTest**********");
		try
		{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		logger.info("Clicked on my account link ");
		homePage.clickOnRegister();
		logger.info("Clicked on register link ");
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		logger.info("providing customer details ");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString() + "@gmail.com");
		regPage.setTelephone(randomNumber());

		String pass = randomAlphaNumeric();
		regPage.setPassword(pass);
		regPage.setPasswordConfirm(pass);
		regPage.checkPrivacyAgree();
		regPage.clickContinue();
		logger.info("validating expected message");
		String confirmationMessge = regPage.getConfirmationMsg();
		if(confirmationMessge.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);
			
		}
		
			}
		catch (Exception e) {
			logger.error("verifyAccountRegistration::",e);
			Assert.fail();
		}
		logger.info("*********** Finished TC001_AccountRegistrationTest**********");
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
}
