package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;

public class HomePageTest {
	public static WebDriver driver;
	private String SUMMER_DRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";

	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	
	//Tests if "Summer dresses" link opens from "WOMAN" menu
	@Test 
	public void test01WomenBtn() {
		driver.navigate().to(HomePage.HOME_URL);
		HomePage.ClickWomenSummer(driver);
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, SUMMER_DRESSES_URL);
	}

	//Tests if "Summer dresses" link opens from "DRESSES" menu
	@Test
	public void test02DressBtn() {
		driver.navigate().to(HomePage.HOME_URL);
		HomePage.ClickDressSummer(driver);
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, SUMMER_DRESSES_URL);
	}
	
	//Tests if the links in test01 i test02 lead to same page.
	@Test
	public void test03SameURL() {
		driver.navigate().to(HomePage.HOME_URL);
		String current1 = HomePage.ClickDressSummer(driver);
		
		driver.navigate().to(HomePage.HOME_URL);
		String current2 = HomePage.ClickWomenSummer(driver);;
		
		Assert.assertEquals(current1, current2);
	}
}
	

