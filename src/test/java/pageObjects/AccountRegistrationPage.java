package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath ="//input[@placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath ="//input[@placeholder='E-Mail']")
	WebElement eMail;
	
	@FindBy(xpath ="//input[@placeholder='Telephone']")
	WebElement telephone;
	
	@FindBy(xpath ="//input[@placeholder='Password']")
	WebElement password;
		
	@FindBy(xpath ="//input[@placeholder='Password Confirm']")
	WebElement passwordConfirm;
	
	@FindBy(xpath ="//input[@name='agree']")
	WebElement privacyAgree;
	
	@FindBy(xpath ="//input[@value='Continue']")
	WebElement continuButton;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		eMail.sendKeys(email);
	}
	public void setTelephone(String telphonenum)
	{
		telephone.sendKeys(telphonenum);
	}
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void setPasswordConfirm(String pass)
	{
		passwordConfirm.sendKeys(pass);
	}
	public void checkPrivacyAgree()
	{
		privacyAgree.click();
	}
	public void clickContinue()
	{
		continuButton.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
	
	
	
}
	
	

