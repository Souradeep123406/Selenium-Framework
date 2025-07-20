package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test

	public void verify_account_registration() {

		try {

			logger.info("***** starting TC001_AccountRegistrationtest   *****");

			HomePage hp = new HomePage(driver);

			logger.info("***** clicked on my account link ******");
			hp.clickMyAccount();

			logger.info("**** clicked on register aplication ******");
			hp.clickRegister();

			logger.info("providing customer details......************");
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

			logger.info("validating expected message");
			String confirmationMsg = regpage.getConfirmationMsg();

			if (confirmationMsg.equals("Your Account Has Been Created!")) {

				AssertJUnit.assertTrue(true);
			} else {
				logger.error("Test Failed");

				logger.debug("debug logs");

				AssertJUnit.assertTrue(false);
				
				logger.info("test failed");

			}
		}

		// Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");}

		catch (Exception e) {

			Assert.fail();
		}

		logger.info("*******Finished TC001_AccountRegistrationtest   *****");
	}

}
