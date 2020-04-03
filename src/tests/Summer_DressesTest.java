package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import pageObjects.Authentication;
import pageObjects.Basket;
import pageObjects.Choosen_dress;
import pageObjects.DataSetImport;
import pageObjects.HomePage;
import pageObjects.Registration;
import pageObjects.Summer_Dresses;

public class Summer_DressesTest {
	private static WebDriver driver;
	public static SoftAssert sa = new SoftAssert();

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

	// Test if item chosen
	@Test
	public void test01_clickFirst() {
		driver.navigate().to(Summer_Dresses.SD_URL);
		Summer_Dresses.ClickFirst(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_product=5&controller=product";
		System.out.println(current);
		Assert.assertEquals(current, expected);
	}

	// Tests if order conducted
	@Test
	public void test02_Order() {

		Choosen_dress.setQuantity(driver, "2");
		By size = new By.ByXPath("//option[contains(text(),'M')]");
		Choosen_dress.setSize(driver, size);
		Choosen_dress.setColour(driver, "Blue");
		Choosen_dress.addChartBtn(driver);

		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?controller=order";
		Assert.assertEquals(current, expected);
	}

	// Tests of the right values set, given in the previous test
	// Assert that user proceeded to registration
	@Test
	public void test03_Values() {
		String actual = Basket.getColorSize(driver);
		sa.assertEquals(actual, "Color : Blue, Size : M");

		actual = Basket.getQty(driver);
		sa.assertEquals(actual, "2");

		actual = Basket.getTitle(driver);
		sa.assertEquals(actual, "Printed Summer Dress");

		sa.assertTrue(Basket.proceeded(driver));

		sa.assertAll();
	}

	// Registration of one user, who already added to cart
	// Assert user registered
	// Asserts that user is logged in, and logout

	@Test
	public void test04_registration() throws IOException {
		String email = DataSetImport.readCell(1, 3);
		Authentication.createAccount(driver, email);

		Registration.setMrMrs(driver, DataSetImport.readCell(1, 0));
		Registration.setFirstName(driver, DataSetImport.readCell(1, 1));
		Registration.setLastName(driver, DataSetImport.readCell(1, 2));
		Registration.setPassword(driver, DataSetImport.readCell(1, 4));
		Registration.setDateOfBirth(driver, DataSetImport.readCell(1, 5), DataSetImport.readCell(1, 6),
				DataSetImport.readCell(1, 7));
		Registration.setSubscription(driver, DataSetImport.readCell(1, 8), DataSetImport.readCell(1, 9));
		Registration.setAddress(driver, DataSetImport.readCell(1, 11));
		Registration.setCity(driver, DataSetImport.readCell(1, 13));
		Registration.setState(driver, DataSetImport.readCell(1, 14));
		Registration.setZIP(driver, DataSetImport.readCell(1, 15));
		Registration.setMobile(driver, DataSetImport.readCell(1, 17));
		Registration.setAlias(driver, DataSetImport.readCell(1, 18));

		Assert.assertTrue(Registration.registerBtn(driver));
		driver.findElement(By.xpath("//div[@class='header_user_info']//a[@title='Log me out']")).click();

	}

	// Login back same user as in test 04_registration
	// Assert items are still in cart
	@Test
	public void test05_logInBack() throws IOException {

		HomePage.signInFromHome(driver);
		Authentication.logInData(driver, DataSetImport.readCell(1, 3), DataSetImport.readCell(1, 4));
		sa.assertTrue(Authentication.clickSignIn(driver));
		String actual = driver
				.findElement(By.xpath("//div[@class='shopping_cart']//span[@class='ajax_cart_no_product']")).getText();
		sa.assertEquals(actual, "2");
		sa.assertAll();

	}

	// Some corrections done during the process.
	// ..not to be deleted, yet.
	@Ignore
	@Test
	public void test04_Qty() {
		String actual = Basket.getQty(driver);
		Assert.assertEquals(actual, "2");
	}

	@Ignore
	@Test
	public void test05_Title() {
		String actual = Basket.getTitle(driver);
		Assert.assertEquals(actual, "Printed Summer Dress");
	}

	@Ignore
	@Test
	public void test06_proceedBtn() {
		Assert.assertTrue(Basket.proceeded(driver));

	}

	@Ignore
	@Test
	public void test04_register() throws IOException {
		String email = DataSetImport.readCell(1, 3);
		Authentication.createAccount(driver, email);

	}

}
