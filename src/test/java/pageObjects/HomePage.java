package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@id='top-links']//a[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	
	@FindBy(xpath ="//a[text()='Register']")
	WebElement linkRegister;
	
	@FindBy(xpath ="//a[text()='Login']")
	WebElement linkLogin;
	@FindBy(xpath ="//input[@name='search']")
	WebElement searchBox;
	
	public void clickOnMyAccount()
	{
		
		
		linkMyAccount.click();
	}
	public void clickOnRegister()
	{
		
		linkRegister.click();
	}
	public void clickOnLogin()
	{
		
		linkLogin.click();
	}
	public void enterProductName(String pName)   //For Search Product Test
	{
		searchBox.sendKeys(pName);
	}

	public void clickSearch()  //For Search Product Test
	{
		searchBox.click();
	}
	
}

