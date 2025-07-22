package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;//log4j
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass
	@Parameters({ "os", "browser" })

	public void setup(String os, String browser) throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config.properties");

		p = new Properties();
		p.load(file);

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			return;

		}

		logger = LogManager.getLogger(this.getClass());

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("appURL1")); // reading url from property file
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
