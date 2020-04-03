package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Authentication;
import pageObjects.DataSetImport;
import pageObjects.HomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginTest {

	private static WebDriver driver;
	private static SoftAssert sa = new SoftAssert();

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}

	// Log in of n users, registered by Registration class
	// Assert all registered users can log back in
	// Test should be run after Registration test, with same number of users.

	@Test
	public void testN_LogIn() throws IOException {
		int n = 2;
		for (int i = 2; i <= n + 1; i++) {
			HomePage.signInFromHome(driver);
			Authentication.logInData(driver, DataSetImport.readCell(i, 3), DataSetImport.readCell(i, 4));
			sa.assertTrue(Authentication.clickSignIn(driver));
			driver.findElement(By.xpath("//div[@class='header_user_info']//a[@title='Log me out']")).click();
		}
		sa.assertAll();
	}
}
