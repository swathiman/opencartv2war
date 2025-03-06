package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {
	@Test(groups = "DataDriven", dataProvider = "LoginData",dataProviderClass =DataProviders.class )
	public void verify_LoginDDT(String email,String password,String expectedResult)
	{
		logger.info("*********** Strarting TC_003LoginDataDrivenTest***************** ");
		try
		{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		logger.info("clicked on my account link");
		homePage.clickOnLogin();
		logger.info("clicked on login link");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(email);
		
		loginPage.setPassword(password);
		
		loginPage.clickOnLogin();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		
		boolean targetPage=myAccountPage.isMyAccountPageExists();
		if(expectedResult.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				myAccountPage.clickOnLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
				
			}
		}
		else
		{
			if(targetPage==true)
			{
				myAccountPage.clickOnLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
				
			}
			
		}
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("*********** Strarting TC_003LoginDataDrivenTest***************** ");
	}

}
