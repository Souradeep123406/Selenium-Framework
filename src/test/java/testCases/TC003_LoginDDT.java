package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String res) {

		logger.info("****************started TC003*****************");
		try {
			// Homepage
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();

			hp.clickLogin();

			// Loginpage
			LoginPage lp = new LoginPage(driver);

			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// MyAccounPage
			MyAccountPage macc = new MyAccountPage(driver);

			boolean myAccountExist = macc.isMyAccountExist();

			if (res.equalsIgnoreCase("valid")) {

				if (myAccountExist == true) {

					macc.clickLogout();
				} else {
					Assert.assertTrue(false);
				}

			}
			if (res.equalsIgnoreCase("invalid")) {

				if (myAccountExist == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {

					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {

			logger.error("Test failed due to exception: ", e);
			Assert.fail("Exception occurred: " + e.getMessage());

		}
		logger.info("(***********Finished TC003**********************");

	}
}
