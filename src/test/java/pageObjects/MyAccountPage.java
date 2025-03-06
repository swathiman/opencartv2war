package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath ="//h2[text()='My Account']")
	WebElement headerMessage;
	@FindBy(xpath ="//a[@class='list-group-item' and text()='Logout']")
	WebElement linkLogout;
	
	
public boolean isMyAccountPageExists()
{
	try
	{
		return headerMessage.isDisplayed();
	}
	catch (Exception e) {
		return false;
	}
	
}
public void clickOnLogout()
{
	linkLogout.click();
}
}
