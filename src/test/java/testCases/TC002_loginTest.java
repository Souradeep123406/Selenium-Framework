package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_loginTest extends BaseClass {

	@Test
	public void verifyLogin() {

		logger.info("*********** starting TC002_LOGIN TEST *********");

		try {

			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();

			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);

			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);

			boolean myAccountExist = macc.isMyAccountExist();

			AssertJUnit.assertEquals(myAccountExist, true);
		}

		catch (Exception e) {

			AssertJUnit.fail();
		}

		logger.info("******** finidhed  TC002_LOGIN TEST  ****");

	}

}
