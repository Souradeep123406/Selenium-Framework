package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	@FindBy(xpath = "//a[contains(@class,'list-group-item') and normalize-space()='Logout']")
	WebElement lnklogout;

	public boolean isMyAccountExist() {
		try {

			return msgHeading.isDisplayed();
		} catch (Exception e) {

			return false;
		}

	}

	public void clickLogout() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(lnklogout)).click();
	}

}
