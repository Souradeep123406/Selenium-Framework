package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	

	public void setFirstName(String fname) {

		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {

		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {

		txtEmail.sendKeys(email);
	}

	public void setTelephone(String Telephone) {

		txtTelephone.sendKeys(Telephone);
	}

	public void setPassword(String password) {

		txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String ConfirmPassword) {

		txtConfirmPassword.sendKeys(ConfirmPassword);
	}

	public void setPrivacyPolicy(String chkPolicy) {

		txtPassword.sendKeys(chkPolicy);
	}

	public void ClickContinue(String chkPolicy) {

		btnContinue.click();
	}

}
