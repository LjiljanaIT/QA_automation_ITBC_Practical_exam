package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Authentication;
import pageObjects.DataSetImport;
import pageObjects.HomePage;
import pageObjects.Registration;

public class RegistrationTest {
	private static WebDriver driver;
	private static SoftAssert sa = new SoftAssert();

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(HomePage.HOME_URL);
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}

	// Registration of n new users, from Home page
	// Using data-set provided in excel table (attached)
	// Assert all users registered.
	// Note1 for teachers: new data provided in table, you can run it...:)
	// Note2 for teachers: please set number of users you want to register :)
	@Test
	public void testN_register() throws IOException {

		int n = 2;
		// for-loops starts from 2. Reason: when running suite first user is registered
		// in another test.
		for (int r = 2; r <= n + 1; r++) {

			HomePage.signInFromHome(driver);
			Authentication.createAccount(driver, DataSetImport.readCell(r, 3));

			Registration.setMrMrs(driver, DataSetImport.readCell(r, 0));

			Registration.setFirstName(driver, DataSetImport.readCell(r, 1));
			Registration.setLastName(driver, DataSetImport.readCell(r, 2));
			Registration.setPassword(driver, DataSetImport.readCell(r, 4));
			Registration.setDateOfBirth(driver, DataSetImport.readCell(r, 5), DataSetImport.readCell(r, 6),
					DataSetImport.readCell(r, 7));
			Registration.setSubscription(driver, DataSetImport.readCell(r, 8), DataSetImport.readCell(r, 9));
			Registration.setAddress(driver, DataSetImport.readCell(r, 11));
			Registration.setCity(driver, DataSetImport.readCell(r, 13));
			Registration.setState(driver, DataSetImport.readCell(r, 14));
			Registration.setZIP(driver, DataSetImport.readCell(r, 15));
			Registration.setMobile(driver, DataSetImport.readCell(r, 17));
			Registration.setAlias(driver, DataSetImport.readCell(r, 18));
			sa.assertTrue(Registration.registerBtnHome(driver));
			driver.findElement(By.xpath("//div[@class='header_user_info']//a[@title='Log me out']")).click();
		}
		sa.assertAll();
	}

}
