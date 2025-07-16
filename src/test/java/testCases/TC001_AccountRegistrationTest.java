package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {



	@Test

	public void verify_account_registration() {

		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName(randomStrings1().toUpperCase());

		regpage.setLastName(randomStrings1().toUpperCase());

		regpage.setEmail(randomStrings1() + "@gmail.com");
		regpage.setTelephone(randomNumber());

		String password = alphanumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.ClickContinue();

		String confirmationMsg = regpage.getConfirmationMsg();

		Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");

	}

	

}
