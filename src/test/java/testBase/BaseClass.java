package testBase;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	public String randomStrings1() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder() // commons-text dependency
				.withinRange('a', 'z').build();

		return generator.generate(5);
	}

	public String randomNumber() {
		long randomNum = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
		return Long.toString(randomNum);
	}

	public String alphanumeric() {
		Random random = new Random();
		StringBuilder letters = new StringBuilder();
		StringBuilder numbers = new StringBuilder();

		// Generate 3 random alphabets (a-z, lowercase)
		for (int i = 0; i < 3; i++) {
			char c = (char) (random.nextInt(26) + 'a');
			letters.append(c);
		}

		// Generate 3 random digits
		for (int i = 0; i < 3; i++) {
			numbers.append(random.nextInt(10));
		}

		return letters.toString() + "@" + numbers.toString();
	}
}
