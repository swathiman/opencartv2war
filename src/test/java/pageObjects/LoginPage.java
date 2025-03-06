package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath ="//input[@name='email']")
	WebElement email;
	@FindBy(xpath ="//input[@name='password']")
	WebElement password;
	@FindBy(xpath ="//input[@type='submit']")
	WebElement clickOnLogin;
	public void setEmail(String semail) {
		email.sendKeys(semail);;
	}
	public void setPassword(String spassword) {
		password.sendKeys(spassword);
	}
	public void clickOnLogin() {
		clickOnLogin.click();
	}
	
	

}
